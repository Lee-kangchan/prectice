package com.future.practice.domain.user.controller;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.domain.user.service.UserService;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.ErrorCode;
import com.future.practice.global.exception.custom.LoginException;
import com.future.practice.global.exception.custom.UserAlreadyExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping(value="/v1/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/login")
    public ResponseEntity<ResponseDefaultDto> login(HttpSession session, UserDto.Login loginDto){
            if(session.getAttribute("user")!=null)  throw new LoginException(ErrorCode.SESSION_EXIST);
            User user = userService.loginService(loginDto);
            session.setAttribute("user", user); //session

            //token 생성, Session 생성
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_LOGIN_MESSAGE).build());
    }

    @PostMapping("/sign")
    public ResponseEntity<ResponseDefaultDto> sign(UserDto.Inform informDto){
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(userService.signService(informDto));
    }

    @PutMapping("")
    public ResponseEntity<ResponseDefaultDto> updateUser( UserDto.Inform informDto, HttpSession session){
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(userService.updateService(informDto, ((User) session.getAttribute("user")).getUserEmail()));
    }
    @GetMapping("")
    public ResponseEntity<User> selectUser(HttpSession session){
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(userService.userInformService((User)session.getAttribute("user")));
    }

    @DeleteMapping("")
    public ResponseEntity<ResponseDefaultDto> deleteUser(HttpSession session){
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(userService.deleteService(((User) session.getAttribute("user")).getUserEmail()));

    }
}
