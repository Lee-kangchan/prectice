package com.future.practice.global.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhone;
}
