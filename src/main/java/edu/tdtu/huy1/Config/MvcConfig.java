package edu.tdtu.huy1.Config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Path;
import java.nio.file.Paths;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        Path bookUploadDir = Paths.get("./book-images");
        Path readerUploadDir = Paths.get("./reader-images");

        String bookUploadPath = bookUploadDir.toFile().getAbsolutePath();
        String readerUploadPath = readerUploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/book-images/**")
                .addResourceLocations("file:/"+bookUploadPath+"/");

        registry.addResourceHandler("/reader-images/**")
                .addResourceLocations("file:/"+readerUploadPath+"/");
    }
}
