package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.CommentDto;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public void insertComment(CommentDto commentDto, int boardSeq) {

    }
    @Override
    public void insertBigComment(CommentDto commentDto, int commentSeq) {

    }
    @Override
    public void deleteComment(int commentSeq) {

    }
    @Override
    public void deleteBigComment(int bigCommentSeq) {

    }
}
