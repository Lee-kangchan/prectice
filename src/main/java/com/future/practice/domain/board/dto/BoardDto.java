package com.future.practice.domain.board.dto;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class BoardDto {

    private String title;
    private String content;


}
