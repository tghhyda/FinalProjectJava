package com.trangiahuytdtu.finalproject.Config;

import com.trangiahuytdtu.finalproject.entities.Reader;
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
}
