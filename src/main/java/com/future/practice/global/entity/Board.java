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
public class Board {
    private long boardSeq;
    private String boardTitle;
    private String boardContent;
    private LocalDateTime boardCreatedAt;
    private LocalDateTime boardModifiedAt;
    private long boardUserSeq;
}
