package com.future.practice.global.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BigComment {
    private long bigCommentSeq;
    private String bigCommentContent;
    private LocalDateTime bigCommentCreatedAt;
    private LocalDateTime bigCommentModifiedAt;
    private long bigCommentCommentSeq;
    private String bigCommentUserEmail;
}
