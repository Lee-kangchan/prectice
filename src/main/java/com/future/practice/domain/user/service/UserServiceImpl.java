package com.future.practice.domain.user.service;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.mapper.UserMapper;
import com.future.practice.global.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public User loginService(UserDto.Login loginDto) {

        User user = userMapper.findOneByEmailAndPassword(loginDto.toEntity());
        if(user.getUserEmail()==null) new NullPointerException(); // 아이디 패스워드 정보없는 exception 처리
        return user;
    }

    @Override
    public User userInformService(User user){
        return userMapper.findOneByEmail(user);
    }

    @Override
    public void signService(UserDto.Inform informDto) {
        userMapper.save(informDto.toEntity());
    }

    @Override
    public void updateService(UserDto.Inform informDto, String email) {
        userMapper.updateByUserPasswordAndUserNameAndUserPhone(informDto.toEntity(email));
    }

    @Override
    public void deleteService(String email) {
        User user = User.builder().userEmail(email).build();
        userMapper.deleteByUserEmail(user);
    }
}
