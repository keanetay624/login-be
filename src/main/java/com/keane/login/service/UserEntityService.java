package com.keane.login.service;

import com.keane.login.dto.UserCreateDto;
import com.keane.login.dto.UserDto;
import com.keane.login.entity.UserEntity;
import com.keane.login.exception.UserEntityNotFoundException;
import com.keane.login.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserEntityService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserDto findUserByUsername(String username) {
        UserEntity userEntity = Optional.of(userRepository
                .findByUserName(username))
                .get()
                .orElseThrow(()-> new UserEntityNotFoundException(username));
        return new UserDto(userEntity.getId(),
                userEntity.getUserName(),
                userEntity.getFullName(),
                userEntity.getIsManager());
    }

    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntity = userRepository.findAll();
        return userEntity.stream()
                .map(user -> new UserDto(user.getId(),
                    user.getUserName(),
                    user.getFullName(),
                    user.getIsManager())
                ).collect(Collectors.toList());
    }

    public void addUser(UserCreateDto user) {
        UserEntity userEntity = new UserEntity(user.getUserName(), passwordEncoder.encode(user.getPassword()),
                user.getFullName(), user.getIsManager());
        userRepository.save(userEntity);
    }
}
