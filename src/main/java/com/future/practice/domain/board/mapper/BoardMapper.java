package com.future.practice.domain.board.mapper;

import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;

import java.util.List;

public interface BoardMapper {
    public void insertBoard(Board board);
    public void updateBoard(Board board);
    public void deleteBoard(Board board);
    public List<Board> selectBoard();
    public Board selectBoardDetail(Board board);
}
