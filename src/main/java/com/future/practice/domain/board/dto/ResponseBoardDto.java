package com.future.practice.domain.board.dto;

import com.future.practice.global.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.minidev.json.annotate.JsonIgnore;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBoardDto {
    int code;
    int length;
    int page;
    List<Board> board;

}
