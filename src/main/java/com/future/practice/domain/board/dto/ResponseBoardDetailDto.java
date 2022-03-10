package com.future.practice.domain.board.dto;

import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoardDetailDto {
    private int code;
    private Board board;
    private List<CommentAll> commentAll;


}
