package com.isa.spring.security.guide.lesson11;


import java.util.ArrayList;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public class MyUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new UserAuthority("SITEA"));
        authorities.add(new UserAuthority("SITEB"));
        return new User("user", "password", authorities);
    }
}
