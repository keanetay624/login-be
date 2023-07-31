package com.keane.login.service;

import com.keane.login.entity.UserEntity;
import com.keane.login.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = userRepository.findByUserName(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException(username);
        }
        UserDetails userDetails = User
                .withUsername(userEntity.getUserName())
                .password(userEntity.getPassword())
                .authorities("USER")
                .roles("USER")
                .build();
        System.out.println(userDetails);
        return userDetails;
    }
}
