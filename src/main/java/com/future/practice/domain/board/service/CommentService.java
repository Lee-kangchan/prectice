package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.CommentDto;

public interface CommentService {
    public void insertComment(CommentDto commentDto, int boardSeq);
    public void insertBigComment(CommentDto commentDto, int commentSeq);
    public void deleteComment(int commentSeq);
    public void deleteBigComment(int bigCommentSeq);
}
