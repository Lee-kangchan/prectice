package com.future.practice.domain.board.mapper;

import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface BoardMapper {
    public void save(Board board);
    public void updateByBoardSeq(Board board);
    public void deleteByBoardSeq(Board board);
    public List<Board> findAll(Map<String, Object> map);
    public Board findOneByBoardSeq(long boardSeq);
    public List<Board> findAllByLikeSearch(Map<String, Object> map);
}
