package com.trangiahuytdtu.finalproject.Config;

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
        String brandUploadPath = bookUploadDir.toFile().getAbsolutePath();

        registry.addResourceHandler("/book-images/**")
                .addResourceLocations("file:/"+brandUploadPath+"/");
    }
}
