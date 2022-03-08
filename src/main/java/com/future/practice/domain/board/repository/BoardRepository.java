package com.future.practice.domain.board.repository;

import com.future.practice.domain.board.mapper.BoardMapper;
import com.future.practice.global.entity.Board;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BoardRepository {
    private BoardMapper mapper;
    private SqlSession sqlSession;

    public BoardRepository(SqlSession sqlSession){
        this.sqlSession = sqlSession;
        mapper = sqlSession.getMapper(BoardMapper.class);
    }

    public void insertBoard(Board board){
        mapper.insertBoard(board);
    }
    public void updateBoard(Board board){
        mapper.updateBoard(board);
    }
    public void deleteBoard(Board board){
        mapper.deleteBoard(board);
    }
    public List<Board> selectBoard(){
        return mapper.selectBoard();
    }
    public Board selectBoardDetail(Board board){
        return mapper.selectBoardDetail(board);
    }
}
