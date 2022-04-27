package com.future.practice.global.entity;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
@Entity
@DynamicUpdate
public class User {
    @Id
    private String userEmail;
    @Column(length = 100, nullable = false)
    private String userPassword;
    @Column(length = 100, nullable = false)
    private String userName;
    @Column(length = 100, nullable = false)
    private String userPhone;
}
