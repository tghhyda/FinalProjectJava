package com.trangiahuytdtu.finalproject.Config;

import com.trangiahuytdtu.finalproject.entities.Reader;
import com.trangiahuytdtu.finalproject.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CostumeUserDetailService implements UserDetailsService {
    @Autowired private ReaderRepository readerRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Reader reader = readerRepo.findByEmail(username);
        if(reader == null){
            throw new UsernameNotFoundException("No reader found for the given email");
        }
        return new CustumeUserDetails(reader);
    }
}
