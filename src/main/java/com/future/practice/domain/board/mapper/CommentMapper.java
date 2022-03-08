package com.future.practice.domain.board.mapper;

import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;

import java.util.List;

public interface CommentMapper {

    public void insertComment(Comment comment);
    public List<Comment> selectComment (Board board);
    public void deleteComment (Comment comment);
}
