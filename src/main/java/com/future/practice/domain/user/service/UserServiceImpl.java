package com.future.practice.domain.user.service;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.mapper.UserMapper;
import com.future.practice.global.constant.Common;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.custom.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.regex.Pattern;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public User loginService(UserDto.Login loginDto) {

        if(!userMapper.findOneByEmail(loginDto.toEntity()).isPresent()) throw new EmailNotExistException(); // 이메일 존재 X
        User user = userMapper.findOneByEmailAndPassword(loginDto.toEntity()).get();
        if(user==null) throw new UserPasswordWrongException(); // 유저 패스워드 오류
        return user;
    }

    @Override
    public User userInformService(User user){
        return userMapper.findOneByEmail(user).get();
    }

    @Override
    @Transactional
    public void signService(UserDto.Inform informDto) {
        //이메일 중복 체크
        if(userMapper.findOneByEmail(informDto.toEntity()) != null) throw new EmailAlreadyExistException();

        //패스워드 유효성 체크
        String password= informDto.getPassword();
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{4,20}$");// 영문 숫자 포함 확인

        if(!passwordPattern.matcher(password).find()){
            throw new PasswordRulesViolationException();
        }

        // 휴대폰 중복 체크 -> 1명 : 1계정
        if(userMapper.findOneByPhone(informDto.toEntity()) != null) throw new UserAlreadyExistException();
        userMapper.save(informDto.toEntity());
    }

    @Override
    @Transactional
    public void updateService(UserDto.Inform informDto, String email) {

        //패스워드 유효성 체크
        String password= informDto.getPassword();
        Pattern passwordPattern = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d).{8,20}$"); // 영문 숫자 포함 확인
        if(password.length() < Common.PASSWORD_LENGTH || !passwordPattern.matcher(password).find()){
            throw new PasswordRulesViolationException();
        }
        //유저 존재 여부 확인
        if(userMapper.findOneByEmail(informDto.toEntity(email)) == null) throw new UserNotExistException();
        userMapper.updateByUserPasswordAndUserNameAndUserPhone(informDto.toEntity(email));
    }

    @Override
    @Transactional
    public void deleteService(String email) {
        User user = User.builder().userEmail(email).build();
        //유저 존재 여부 확인
        if(userMapper.findOneByEmail(user) == null) throw new UserNotExistException();
        userMapper.deleteByUserEmail(user);
    }
}
