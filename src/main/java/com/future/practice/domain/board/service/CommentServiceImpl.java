package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.CommentDto;
import com.future.practice.domain.board.mapper.CommentMapper;
import com.future.practice.global.entity.BigComment;
import com.future.practice.global.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Override
    public void insertComment(CommentDto commentDto, long boardSeq, User user) {
        commentMapper.saveComment(commentDto.toCommentEntity(boardSeq, user.getUserEmail()));
    }
    @Override
    public void insertBigComment(CommentDto commentDto, long commentSeq, User user) {
        commentMapper.saveBigComment(commentDto.toBigCommentEntity(commentSeq, user.getUserEmail()) );
    }
    @Override
    public void deleteComment(long commentSeq, User user) {
        commentMapper.deleteCommentByCommentSeq(commentSeq);
    }
    @Override
    public void deleteBigComment(long bigCommentSeq, User user) {
        commentMapper.deleteBigCommentByBigCommentSeq(bigCommentSeq);
    }
}
