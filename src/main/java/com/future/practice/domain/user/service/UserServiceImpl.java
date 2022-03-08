package com.future.practice.domain.user.service;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.repository.UserRepository;
import com.future.practice.global.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Slf4j
@Service("UserService")
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Override
    public User loginService(UserDto.Login loginDto) {
        User user = userRepository.idAndPasswordCheck(loginDto.toEntity());
        log.info(loginDto.getEmail()+" -- "+ loginDto.getPassword());
        if(user.getUserEmail()==null) new Exception(); // 아이디 패스워드 정보없는 exception 처리
        return user;
    }

    @Override
    public void signService(UserDto.Inform informDto) {
        userRepository.signUp(informDto.toEntity());
    }

    @Override
    public void updateService(UserDto.Inform informDto) {
        userRepository.updateUser(informDto.toEntity());
    }

    @Override
    public void deleteService(String email) {
        User user = User.builder().userEmail(email).build();
        userRepository.deleteUser(user);
    }
}
