package com.future.practice.domain.user.controller;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.service.UserService;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.User;
import com.sun.xml.internal.ws.api.message.Header;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RestController
@RequestMapping(value="/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDefaultDto> login(@RequestBody UserDto.Login loginDto){
        User user = userService.loginService(loginDto);

        //token 생성, Session 생성

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_LOGIN_MESSAGE).build());
    }

    @GetMapping("/logout")
    public ResponseEntity<ResponseDefaultDto> logout(){

        log.info("logout");
        return null;
    }

    @PostMapping("/sign")
    public ResponseEntity<ResponseDefaultDto>  sign(@RequestBody UserDto.Inform informDto){
        log.info("sign");
        userService.signService(informDto);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_SIGN_MESSAGE).build());
    }

    @PutMapping("/{userEmail}")
    public ResponseEntity<ResponseDefaultDto>  updateUser(@RequestBody UserDto.Inform informDto, @PathVariable("userEmail") String userEmail){
        log.info("update User");
        userService.updateService(informDto);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_USER_UPDATE_MESSAGE).build());
    }

    @DeleteMapping("/{userEmail}")
    public ResponseEntity<ResponseDefaultDto>  deleteUser(@PathVariable("userEmail") String userEmail){
        log.info("delete User");
        userService.deleteService(userEmail);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_USER_DELETE_MESSAGE).build());
    }
}
