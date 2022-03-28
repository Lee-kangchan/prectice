package com.future.practice.global.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Board {
    @Id
    @GeneratedValue
    private long boardSeq;
    @Column(length = 500, nullable = false)
    private String boardTitle;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String boardContent;
    private LocalDateTime boardCreatedAt;
    private LocalDateTime boardModifiedAt;
    private String boardUserEmail;
}
