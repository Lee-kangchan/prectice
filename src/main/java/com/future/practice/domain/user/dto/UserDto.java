package com.future.practice.domain.user.dto;

import com.future.practice.global.entity.User;
import lombok.*;

public class UserDto {

    @Getter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access= AccessLevel.PROTECTED)
    public static class Login{
        private String email;
        private String password;
        public User toEntity(){
            return User.builder()
                    .userEmail(email)
                    .userPassword(password)
                    .build();
        }

        @Override
        public String toString() {
            return "{" +
                    "\"email\" :\"" + email + '\"' +
                    ", \"password\" : \"" + password + '\"' +
                    '}';
        }
    }

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor(access= AccessLevel.PROTECTED)
    public static class Inform{
        private String email;
        private String password;
        private String name;
        private String phone;
        public User toEntity(){
            return User.builder()
                    .userEmail(email)
                    .userPassword(password)
                    .userName(name)
                    .userPhone(phone)
                    .build();
        }
        public User toEntity(String email){
            return User.builder()
                    .userEmail(email)
                    .userPassword(password)
                    .userName(name)
                    .userPhone(phone)
                    .build();
        }

        @Override
        public String toString() {
            return "{" +
                    "\"email\" : \"" + email + '\"' +
                    ", \"password\" : \"" + password + '\"' +
                    ", \"name\" : \"" + name + '\"' +
                    ", \"phone\" : \"" + phone + '\"' +
                    '}';
        }
    }

}
