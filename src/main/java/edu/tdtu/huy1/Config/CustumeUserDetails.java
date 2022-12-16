package edu.tdtu.huy1.Config;

import edu.tdtu.huy1.entities.Reader;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustumeUserDetails implements UserDetails {

    private Reader reader;

    public CustumeUserDetails(Reader reader) {
        this.reader = reader;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(reader.getRole().toString()));
        return authorities;
    }

    public String encodePassword(String rawPassword){

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        return encodedPassword;
    }

    @Override
    public String getPassword() {
        return reader.getPassword();
    }

    @Override
    public String getUsername() {
        return reader.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getNameReader(){
        return this.reader.getNameReader();
    }

    public String getIdReader(){
        return this.reader.getIdReader();
    }

    public Reader getReader() {
        return this.reader;
    }
}
