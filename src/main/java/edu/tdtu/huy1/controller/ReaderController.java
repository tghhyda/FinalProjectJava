package edu.tdtu.huy1.controller;

import edu.tdtu.huy1.Exception.NotFoundException;
import edu.tdtu.huy1.entities.Loan;
import edu.tdtu.huy1.entities.Reader;
import edu.tdtu.huy1.entities.TypeOfReader;
import edu.tdtu.huy1.service.BookService;
import edu.tdtu.huy1.service.ReaderService;
import edu.tdtu.huy1.service.TypeOfReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class ReaderController {
    @Autowired
    private ReaderService readerService;

    @Autowired
    private TypeOfReaderService typeService;

    @Autowired
    private BookService bookService;

    @GetMapping("/reader/login")
    public String viewReaderLogin(){
        // Trả về url file html
        return "Reader/ReaderLogin";
    }

    @GetMapping("/user/register")
    public String showRegisterForm(Model model){
        model.addAttribute("reader", new Reader());
        List<TypeOfReader> listType = typeService.listAll("");
        model.addAttribute("listType", listType);
        return "Reader/Register";
    }

    @PostMapping("/process_register")
    public String processRegistration(Reader reader){
        readerService.save(reader);
        return "Reader/register_success";
    }

    @GetMapping("/reader/home")
    public String viewReaderHomePage(Model model, @Param("keyword") String keyword){
        // Trả về url file html
        model.addAttribute("listBooks", bookService.listAllBooks(keyword));
//        model.addAttribute("currentReader", readerService.findByEmail())
        model.addAttribute("keyword", keyword);
        model.addAttribute("newLoan", new Loan());
        return "Reader/ReaderHome";
    }
    @PostMapping("register/save")
    public String saveBook(@ModelAttribute(name = "reader") Reader reader,
                           RedirectAttributes ra,
                           @RequestParam("photo") MultipartFile multipartFile) throws IOException {

        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        reader.setImg(fileName);
        Reader savedReader = readerService.save(reader);

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

    @GetMapping("/admin/reader/delete/{id}")
    public String deleteBook(@PathVariable("id") String id , RedirectAttributes ra){
        try {
            readerService.deleteReader(id);
            ra.addFlashAttribute("message","delete success");
        } catch (NotFoundException e) {
            ra.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/admin/reader";
    }
}
