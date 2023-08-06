package com.keane.login.service;

import com.keane.login.entity.UserEntity;
import com.keane.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String roleStringUser = "USER";
        String roleStringManager = "MANAGER";

        final UserEntity userEntity = Optional.of(userRepository
                .findByUserName(username))
                .get()
                .orElseThrow(() -> new UsernameNotFoundException(username));

        return userEntity.getIsManager() == 0 ? User
                .withUsername(userEntity.getUserName())
                .password(userEntity.getPassword())
                .authorities("USER")
                .roles(roleStringUser)
                .build() : User
                .withUsername(userEntity.getUserName())
                .password(userEntity.getPassword())
                .authorities("USER")
                .roles(roleStringUser)
                .roles(roleStringManager)
                .build();
    }
}
