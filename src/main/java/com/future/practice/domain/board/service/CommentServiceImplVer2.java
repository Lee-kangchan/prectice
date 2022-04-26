package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.CommentDto;
import com.future.practice.domain.board.repository.BigCommentRepository;
import com.future.practice.domain.board.repository.BoardRepository;
import com.future.practice.domain.board.repository.CommentRepository;
import com.future.practice.global.entity.BigComment;
import com.future.practice.global.entity.Comment;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.ErrorCode;
import com.future.practice.global.exception.custom.CommentNotAccessException;
import com.future.practice.global.exception.custom.CommentNotFountException;
import com.future.practice.global.exception.custom.CommentException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class CommentServiceImplVer2 implements CommentService{

    private final BigCommentRepository bigCommentRepository;
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Override
    @Transactional
    public void insertComment(CommentDto commentDto, long boardSeq, User user) {
        if(!boardRepository.findBoardByBoardSeq(boardSeq).isPresent()) throw new CommentException(ErrorCode.BOARD_NOT_FOUND);
        commentRepository.save(commentDto.toCommentEntity(boardSeq, user.getUserEmail()));

    }
    @Override
    @Transactional
    public void insertBigComment(CommentDto commentDto, long commentSeq, User user) {
        if(!commentRepository.findCommentByCommentSeq(commentSeq).isPresent()) throw new CommentException(ErrorCode.COMMENT_NOT_FOUND);
        bigCommentRepository.save(commentDto.toBigCommentEntity(commentSeq, user.getUserEmail()));
    }
    @Override
    @Transactional
    public void deleteComment(long commentSeq, User user) {
        if(!commentRepository.findCommentByCommentSeq(commentSeq).isPresent()) throw  new CommentException(ErrorCode.COMMENT_NOT_FOUND);
        if(!commentRepository.findCommentByCommentSeqAndCommentUserEmail(commentSeq, user.getUserEmail()).isPresent()) throw new CommentException(ErrorCode.COMMENT_NOT_ACCESS);

        commentRepository.deleteByCommentSeq(commentSeq);
    }
    @Override
    @Transactional
    public void deleteBigComment(long bigCommentSeq, User user) {
        if(!bigCommentRepository.findBigCommentByBigCommentSeq(bigCommentSeq).isPresent()) throw  new CommentException(ErrorCode.COMMENT_NOT_FOUND);
        if(!bigCommentRepository.findBigCommentByBigCommentSeqAndBigCommentUserEmail(bigCommentSeq, user.getUserEmail()).isPresent()) throw new CommentException(ErrorCode.COMMENT_NOT_ACCESS);

        bigCommentRepository.deleteByBigCommentSeq(bigCommentSeq);
    }
}
