package com.future.practice.domain.user.mapper;

import com.future.practice.global.entity.User;

public interface UserMapper {
    public User idAndPasswordCheck(User user);
    public void signUp(User user);
    public void updateUser(User user);
    public void deleteUser(User user);
}
