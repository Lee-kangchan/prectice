package com.future.practice.domain.board.repository;

import com.future.practice.global.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long > {
    public List<Comment> findAllByCommentBoardSeq(long seq);
    public void deleteByCommentSeq(long seq);
    public Optional<Comment> findCommentByCommentSeq(long commentSeq);
    public Optional<Comment> findCommentByCommentSeqAndCommentUserEmail(long commentSeq, String commentUserEmail);
}
