package com.ecom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ecom.jpa.UsersRepository;
import com.ecom.model.CustomUserDetails;
import com.ecom.model.Users;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    static {
    	System.out.println("CustomUserDetailsService.enclosing_method()");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	System.out.println("before getting data");
        Optional<Users> optionalUsers = usersRepository.findByEmailId(username);
        System.out.println("value of user "+optionalUsers.get());
        System.out.println("after getting data");
        System.err.println(optionalUsers.get().getEmailId()+" "+optionalUsers.get().getPassword());
        	System.out.println("CustomUserDetailsService.loadUserByUsername() se");
        optionalUsers
                .orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return optionalUsers
                .map(CustomUserDetails::new).get();
    }
}
