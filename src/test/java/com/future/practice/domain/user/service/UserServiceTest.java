package com.future.practice.domain.user.service;

import org.junit.Assert;
import static org.junit.Assert.*;
import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.global.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor
@Slf4j
public class UserServiceTest {

    private final UserService userService;

    @Test
    public void selectTest(){
        UserDto.Login loginDto = UserDto.Login.builder().email("abc@naver.com").password("1234").build();
        User user = userService.loginService(loginDto);
        assertEquals(user.getUserName(), "abc");
    }

}
