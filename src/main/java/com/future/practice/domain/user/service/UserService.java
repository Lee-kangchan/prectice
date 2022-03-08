package com.future.practice.domain.user.service;

import com.future.practice.domain.user.dto.UserDto;
import com.future.practice.global.entity.User;

public interface UserService {
    public User loginService(UserDto.Login loginDto);
    public void signService(UserDto.Inform informDto);
    public void updateService(UserDto.Inform informDto);
    public void deleteService(String email);
}
