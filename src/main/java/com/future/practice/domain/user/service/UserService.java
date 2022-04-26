package com.future.practice.domain.user.service;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.User;

public interface UserService {
    public User loginService(UserDto.Login loginDto);
    public ResponseDefaultDto signService(UserDto.Inform informDto);
    public ResponseDefaultDto updateService(UserDto.Inform informDto, String email);
    public ResponseDefaultDto deleteService(String email);
    public User userInformService(User user);
}
