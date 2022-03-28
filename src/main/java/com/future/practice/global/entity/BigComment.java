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
public class BigComment {
    @Id
    @GeneratedValue
    private long bigCommentSeq;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String bigCommentContent;

    private LocalDateTime bigCommentCreatedAt;

    private LocalDateTime bigCommentModifiedAt;
    private long bigCommentCommentSeq;
    private String bigCommentUserEmail;
}
