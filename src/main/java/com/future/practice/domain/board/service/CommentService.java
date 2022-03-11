package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.CommentDto;
import com.future.practice.global.entity.User;

public interface CommentService {
    public void insertComment(CommentDto commentDto, long boardSeq, User user);
    public void insertBigComment(CommentDto commentDto, long commentSeq, User user);
    public void deleteComment(long commentSeq, User user);
    public void deleteBigComment(long bigCommentSeq, User user);
}
