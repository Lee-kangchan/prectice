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

    public void saveComment(Comment comment);
    public List<Comment> findAllByCommentBoardSeq (long boardSeq);
    public void deleteCommentByCommentSeq (long comment);
    public void saveBigComment(BigComment bigComment);
    public List<BigComment> findAllByCommentSeq (long commentSeq);
    public void deleteBigCommentByBigCommentSeq (long bigComment);
    public Comment findOneCommentByCommentSeq (long commentSeq);
    public BigComment findOneBigCommentByBigCommentSeq (long bigCommentSeq);
    public Comment findOneCommentByCommentSeqAndCommentUserEmail(Comment comment);
    public BigComment findOneBigCommentByBigCommentSeqAndBigCommentUserEmail (BigComment bigComment);
}
