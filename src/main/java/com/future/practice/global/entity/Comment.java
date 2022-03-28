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
public class Comment {
    @Id
    @GeneratedValue
    private long commentSeq;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String commentContent;

    private LocalDateTime commentCreatedAt;
    private LocalDateTime commentModifiedAt;
    private long commentBoardSeq;
    private String commentUserEmail;
}
