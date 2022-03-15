package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.CommentDto;
import com.future.practice.domain.board.mapper.BoardMapper;
import com.future.practice.domain.board.mapper.CommentMapper;
import com.future.practice.global.entity.BigComment;
import com.future.practice.global.entity.Comment;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.custom.BoardNotFoundException;
import com.future.practice.global.exception.custom.CommentNotAccessException;
import com.future.practice.global.exception.custom.CommentNotFountException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    private final BoardMapper boardMapper;
    @Override
    public void insertComment(CommentDto commentDto, long boardSeq, User user) {
        if(boardMapper.findOneByBoardSeq(boardSeq)==null) throw new BoardNotFoundException();
        commentMapper.saveComment(commentDto.toCommentEntity(boardSeq, user.getUserEmail()));
    }
    @Override
    public void insertBigComment(CommentDto commentDto, long commentSeq, User user) {
        if(commentMapper.findOneCommentByCommentSeq(commentSeq)==null) throw  new CommentNotFountException();
        commentMapper.saveBigComment(commentDto.toBigCommentEntity(commentSeq, user.getUserEmail()) );
    }
    @Override
    public void deleteComment(long commentSeq, User user) {
        if(commentMapper.findOneCommentByCommentSeq(commentSeq) ==null) throw new CommentNotFountException();
        if(commentMapper.findOneCommentByCommentSeqAndCommentUserEmail(Comment.builder().commentSeq(commentSeq).commentUserEmail(user.getUserEmail()).build()) == null){
            throw new CommentNotAccessException();
        }
        commentMapper.deleteCommentByCommentSeq(commentSeq);
    }
    @Override
    public void deleteBigComment(long bigCommentSeq, User user) {
        if(commentMapper.findOneBigCommentByBigCommentSeq(bigCommentSeq)== null) throw new CommentNotFountException();
        if(commentMapper.findOneBigCommentByBigCommentSeqAndBigCommentUserEmail(BigComment.builder().bigCommentSeq(bigCommentSeq).bigCommentUserEmail(user.getUserEmail()).build()) == null)
            throw new CommentNotFountException();
        commentMapper.deleteBigCommentByBigCommentSeq(bigCommentSeq);
    }
}
