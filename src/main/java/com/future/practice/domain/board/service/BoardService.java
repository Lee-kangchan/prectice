package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.global.entity.Board;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardService {
    public void insertBoardService(BoardDto boardDto);
    public void updateBoardService(BoardDto boardDto, int boardSeq);
    public void deleteBoardService(int boardSeq);
    public List<Board> selectBoardService(int page);
    public ResponseBoardDetailDto selectBoardDetailService(int boardSeq);
    public List<Board> selectSearchBoardService(Map<String, Object> map);
}
