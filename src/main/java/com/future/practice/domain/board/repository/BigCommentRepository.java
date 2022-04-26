package com.future.practice.domain.board.repository;

import com.future.practice.global.entity.BigComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BigCommentRepository extends JpaRepository<BigComment, Long> {
    public List<BigComment> findAllByBigCommentCommentSeq(long bigCommentCommentSeq);
    public Optional<BigComment> findBigCommentByBigCommentSeq(long bigCommentSeq);
    public void deleteByBigCommentSeq(long bigCommentSeq);
    public Optional<BigComment> findBigCommentByBigCommentSeqAndBigCommentUserEmail(long bigCommentSeq, String bingCommentUserEmail);
}
