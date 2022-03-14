package com.future.practice.domain.user.controller;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.service.UserService;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RestController
@RequestMapping(value="/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDefaultDto> login(HttpSession session, UserDto.Login loginDto){
        User user = userService.loginService(loginDto);
        session.setAttribute("user",user); //session
        log.info("loginDto email : "+ loginDto.getEmail() +" password :" + loginDto.getPassword());
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
    public ResponseEntity<ResponseDefaultDto> sign(UserDto.Inform informDto){
        log.info("sign");
        userService.signService(informDto);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_SIGN_MESSAGE).build());
    }

    @PutMapping("")
    public ResponseEntity<ResponseDefaultDto> updateUser( UserDto.Inform informDto, HttpSession session){
        log.info("update User");
        log.info("inform : password : " + informDto.getPassword() + "name" + informDto.getName() + "phone" + informDto.getPhone());
        userService.updateService(informDto, ((User)session.getAttribute("user")).getUserEmail());
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_USER_UPDATE_MESSAGE).build());
    }
    @GetMapping("")
    public ResponseEntity<User> selectUser(HttpSession session){
        log.info("select User");
        User user = userService.userInformService((User)session.getAttribute("user"));
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(user);
    }

    @DeleteMapping("")
    public ResponseEntity<ResponseDefaultDto> deleteUser(HttpSession session){
        log.info("delete User");
        userService.deleteService(((User)session.getAttribute("user")).getUserEmail());

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_USER_DELETE_MESSAGE).build());
    }
}
