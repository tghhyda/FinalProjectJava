package edu.tdtu.huy1.Config;


import edu.tdtu.huy1.entities.Reader;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


@Component
public class PasswordFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        String requestURL = httpRequest.getRequestURL().toString();

        if (requestURL.endsWith(".png") || requestURL.endsWith(".jpg")
                || requestURL.endsWith(".css") || requestURL.endsWith(".js")){

            chain.doFilter(request, response);
            return;
        }
        System.out.println("URL: " + requestURL);

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = null;
        if(authentication != null){
            principal = authentication.getPrincipal();
        }

        if(principal != null && principal instanceof CustumeUserDetails){
            CustumeUserDetails userDetails = (CustumeUserDetails) principal;
            Reader reader = userDetails.getReader();

            System.out.println("Reader " + reader.getNameReader());
        }
        chain.doFilter(request, response);

    }
}
