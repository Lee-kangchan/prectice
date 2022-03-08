package com.future.practice.domain.user.controller;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.service.UserService;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.User;
import com.sun.xml.internal.ws.api.message.Header;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserDto.Login loginDto){
        userService.loginService(loginDto);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity("로그인 하였습니다.",headers, HttpStatus.OK);
    }

    @GetMapping("/logout")
    public void logout(){

    }

    @PostMapping("/sign")
    public void sign(){

    }

    @PutMapping("/{user}")
    public void updateUser(){

    }

    @DeleteMapping("/{user}")
    public void deleteUser(@PathVariable("user") int user_seq){

    }
}
