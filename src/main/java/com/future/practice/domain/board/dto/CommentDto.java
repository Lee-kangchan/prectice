package com.future.practice.domain.board.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class CommentDto {
    private String content;
}
