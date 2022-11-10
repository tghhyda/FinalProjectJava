package edu.tdtu.huy1.Config;

import edu.tdtu.huy1.entities.Reader;
import edu.tdtu.huy1.repository.ReaderRepository;
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
