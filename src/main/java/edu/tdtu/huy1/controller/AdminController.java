package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.entities.Producer;
import edu.tdtu.huy1.entities.Reader;
import edu.tdtu.huy1.entities.TypeOfBook;
import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {
    @Autowired
    ReaderService readerService;

    @Autowired
    BookService bookService;

    @Autowired
    TypeOfReaderService typeOfReaderService;

    @Autowired
    ProducerService producerService;

    @Autowired
    TypeOfBookService typeOfBookService;

    @Autowired
    LoanService loanService;

    @Autowired
    PasswordEncoder passwordEncoder;


    @GetMapping("/admin/login")
    public String viewAdminLogin(){
        return "Admin/AdminLogin";
    }

    @GetMapping("/admin/home")
    public String viewAdminHomePage(Model model){
        String keyword = "";
        model.addAttribute("listBooks", bookService.listAllBooks(keyword));
        model.addAttribute("listReaders", readerService.list4LatestReader());
        return "Admin/AdminHome";
    }

    @GetMapping("/admin/book")
    public String viewAdminBook(Model model, @Param("keyword") String keyword){
        model.addAttribute("listBooks", bookService.listAllBooks(keyword));
        model.addAttribute("keyword", keyword);
        return "Admin/AdminBook";
    }

    @GetMapping("/admin/reader")
    public String viewAdminReader(Model model, @Param("keyword") String keyword){
        model.addAttribute("listReaders", readerService.listAllReader(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("listType", typeOfReaderService.listAll(""));
        return "Admin/AdminReader";
    }

    @GetMapping("/admin/producer")
    public String viewAdminProducer(Model model, @Param("keyword") String keyword){
        model.addAttribute("listProducers", producerService.listAllProducer(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("newProducer", new Producer());

        return "Admin/AdminProducer";
    }

    @GetMapping("/admin/typereader")
    public String viewAdminTypeReader(Model model, @Param("keyword") String keyword){
        model.addAttribute("listType", typeOfReaderService.listAll(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("newType", new TypeOfReader());

        return "Admin/AdminTypeReader";
    }

    @GetMapping("/admin/typebook")
    public String viewAdminTypeBook(Model model, @Param("keyword") String keyword){
        model.addAttribute("listType", typeOfBookService.listAllTypeBook(keyword));
        model.addAttribute("keyword", keyword);
        model.addAttribute("newType", new TypeOfBook());

        return "Admin/AdminTypeBook";
    }

    @GetMapping("/admin/transaction")
    public String viewAdminTransaction(Model model, @Param("keyword") String keyword){
        model.addAttribute("listLoan", loanService.listAll(keyword));
        model.addAttribute("keyword",keyword);

        return "Admin/AdminTransaction";
    }

    @GetMapping("/admin/register")
    public String showRegisterForm(Model model){
        model.addAttribute("reader", new Reader());
        List<TypeOfReader> listType = typeOfReaderService.listAll("");
        model.addAttribute("listType", listType);
        return "Admin/AdminRegister";
    }

    @PostMapping("admin/save")
    public String saveReader(@ModelAttribute(name = "reader") Reader reader,
                             RedirectAttributes ra,
                             @RequestParam("photo") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        reader.setImg(fileName);
        Reader savedReader = readerService.saveAdmin(reader);

        String uploadDir = "./reader-images/" + savedReader.getIdReader();
        Path uploadReaderPath = Paths.get(uploadDir);

        if(!Files.exists(uploadReaderPath)){
            Files.createDirectories(uploadReaderPath);
        }

        try(InputStream inputStream = multipartFile.getInputStream()){
            Path filePath = uploadReaderPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("Could not save uploaded file"+fileName);
        }


        ra.addFlashAttribute("message","Saved successfully");

        return "redirect:/admin/reader";
    }

    @GetMapping("admin/profile/{email}")
    public String viewAdminProfile(Model model, @PathVariable("email") String email){
        Reader admin = readerService.findByEmail(email);
        model.addAttribute("listType", typeOfReaderService.listAll(""));
        model.addAttribute("admin", admin);
        return "Admin/AdminProfile";
    }

    @GetMapping("/admin/change-password/{email}")
    public String viewChangePasswordPage(Model model){
        model.addAttribute("pageTitle","Change your password");
        return "Admin/ChangePassword";
    }

    @PostMapping("/admin/change-password/{email}")
    public String processChangePassword(Model model, HttpServletRequest request,
                                        HttpServletResponse response,
                                        @PathVariable("email") String email){

        Reader reader = readerService.findByEmail(email);

        String oldPassword = request.getParameter("oldPassword");
        String newPassword = request.getParameter("newPassword");
        String confirmPassword = request.getParameter("confirmPassword");

        if (!passwordEncoder.matches(oldPassword, reader.getPassword())){
            model.addAttribute("pageTitle","Change your password");
            model.addAttribute("message","Your old password is incorrect!");
            return "Admin/ChangePassword";
        }

        if(!confirmPassword.equals(newPassword)){
            model.addAttribute("pageTitle","Change your password");
            model.addAttribute("message", "Confirm password is not match");
            return "Admin/ChangePassword";
        }else{
            readerService.updatePassword(newPassword, reader, passwordEncoder);
            model.addAttribute("pageTitle","Change your password");
            model.addAttribute("message","Your password is already changed, login again");
            return "Admin/AdminLogin";
        }
    }
}