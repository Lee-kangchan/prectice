package com.future.practice.domain.board.mapper;

import com.future.practice.global.entity.BigComment;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface CommentMapper {

    public void insertComment(Comment comment);
    public List<Comment> selectComment (long boardSeq);
    public void deleteComment (Comment comment);
    public void insertBigComment(BigComment bigComment);
    public List<BigComment> selectBigComment (long commentSeq);
    public void deleteBigComment (BigComment bigComment);
}
