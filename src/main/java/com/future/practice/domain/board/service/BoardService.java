package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.dto.ResponseBoardDto;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardService {
    public String insertBoardService(BoardDto boardDto, User user);
    public String updateBoardService(BoardDto boardDto, long boardSeq, User user);
    public String deleteBoardService(long boardSeq, User user);
    public ResponseBoardDto selectBoardService(Map<String, Object> map);
    public ResponseBoardDetailDto selectBoardDetailService(long boardSeq);
    public ResponseBoardDto selectSearchBoardService(Map<String, Object> map);
}
