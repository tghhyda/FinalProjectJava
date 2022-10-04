package com.trangiahuytdtu.finalproject.Config;

import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.entities.Role;
import com.trangiahuytdtu.finalproject.entities.TypeOfReader;
import com.trangiahuytdtu.finalproject.repository.ReaderRepository;
import com.trangiahuytdtu.finalproject.repository.TypeOfReaderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Configuration
public class DatabaseLoader {
    private ReaderRepository readerRepo;
    private TypeOfReaderRepository typeOfReaderRepository;

    public DatabaseLoader(ReaderRepository readerRepo, TypeOfReaderRepository typeOfReaderRepository){
        this.readerRepo = readerRepo;
        this.typeOfReaderRepository = typeOfReaderRepository;
    }

    // Mã hóa mật khẩu
    public String encodePassword(String rawPassword){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        return encodedPassword;
    }

    // Tạo dữ liệu ban đầu
    @Bean
    public CommandLineRunner initializeDatabase(){
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmmss");
        String currentTime = formatter.format(new Date());

        return args -> {
            TypeOfReader typeOfReader1 = new TypeOfReader("TOD1"+currentTime,"Student","Nothing");
            TypeOfReader typeOfReader2 = new TypeOfReader("TOD2"+currentTime,"Teacher","Nothing");

            // Kiểm tra xem đã tồn tại chưa
            for(TypeOfReader type : List.of(typeOfReader1, typeOfReader2)){
                if(typeOfReaderRepository.findByName(type.getName()) == null)
                    typeOfReaderRepository.save(type);
                else continue;
            }

            Reader reader1 = new Reader("Reader1"+currentTime, typeOfReader1, "Tran Gia Huy",
                                        "trangiahuy.hyda@gmail.com", encodePassword("giahuy"), Role.READER,
                                        "0793557129","TDTU Dorminatory");
            Reader reader2 = new Reader("Reader2"+currentTime, typeOfReader1, "Reader",
                                        "reader@gmail.com", encodePassword("reader"), Role.READER,
                                        "0793557128","TDTU Dorminatory");

            Reader reader3 = new Reader("Reader3"+currentTime, typeOfReader2, "Nguyen Thanh Phong",
                                        "nguyenthanhphong@gmail.com", encodePassword("thanhphong"), Role.ADMIN,
                                        "0320333112","Somewhere");
            Reader reader4 = new Reader("Reader4"+currentTime, typeOfReader2, "Admin",
                                        "admin@gmail.com", encodePassword("admin"), Role.ADMIN,
                                        "0327393512","Somewhere");

            // Kiểm tra xem đã tồn tại chưa
            for(Reader reader : List.of(reader1, reader2, reader3,reader4)){
                if(readerRepo.findByEmail(reader.getEmail()) == null)
                    readerRepo.save(reader);
                else continue;
            }

            System.out.println("Sample database initialize");
        };
    }

}
