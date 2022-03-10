package com.future.practice.global.entity;


import lombok.*;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class User {
    private String userEmail;
    private String userPassword;
    private String userName;
    private String userPhone;
}
