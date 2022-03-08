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
public class Comment {
    private long commentSeq;
    private String commentContent;
    private LocalDateTime commentCreatedAt;
    private LocalDateTime commentModifiedAt;
    private long commentBoardSeq;
}
