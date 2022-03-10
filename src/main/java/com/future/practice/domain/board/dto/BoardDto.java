package com.future.practice.domain.board.dto;

import com.future.practice.global.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class BoardDto {

    private String title;
    private String content;

    public Board toEntity(){
        LocalDateTime time = LocalDateTime.now();

        return Board.builder()
                .boardTitle(title)
                .boardContent(content)
                .boardCreatedAt(time)
                .boardModifiedAt(time)
                .build();
    }
    public Board toEntity(int boardSeq){
        LocalDateTime time = LocalDateTime.now();

        return Board.builder()
                .boardTitle(title)
                .boardContent(content)
                .boardCreatedAt(time)
                .boardModifiedAt(time)
                .boardSeq(boardSeq)
                .build();
    }

}
