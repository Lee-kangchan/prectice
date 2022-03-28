package com.future.practice.domain.user.service;

import com.future.practice.global.dto.ResponseDefaultDto;
import org.junit.Assert;
import static org.junit.Assert.*;
import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.global.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import javax.servlet.http.HttpSession;

@SpringBootTest
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @DisplayName("멤버 조회")
    void selectTest(HttpSession session){
        UserDto.Login loginDto = UserDto.Login.builder().email("abc@naver.com").password("1234").build();
//        assertEquals(user.getBody().getMessage().getUserName(), "abc");
    }

    @Test
    @DisplayName("로그인")
    void login(){
        UserDto.Login loginDto = UserDto.Login.builder().email("abc@naver.com").password("1234").build();
//        User user = userService.loginService(loginDto);
//        assertEquals(loginDto.getEmail(),user.getUserEmail());
//        assertEquals(loginDto.getPassword(),user.getUserPassword());
    }

    @Test
    @DisplayName("회원가입")
    void sign(){
        UserDto.Inform informDto = UserDto.Inform.builder().email("abcdfg@naver.com").password("1234").name("abcdef").phone("010-3533-2224").build();
        userService.signService(informDto);
    }

    @Test
    @DisplayName("회원 수정")
    void update(){
        String email = "abcdfg@naver.com";
        UserDto.Inform informDto = UserDto.Inform.builder().email("abcdfg@naver.com").password("1234").name("abcdef").phone("010-3533-2224").build();
        userService.updateService(informDto,email);
    }

    @Test
    @DisplayName("회원 탈퇴")
    void delete(){
        String email = "abcdfg@naver.com";
        userService.deleteService(email);
    }

}
