package com.future.practice.domain.board.repository;

import com.future.practice.global.entity.BigComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BigCommentRepository extends JpaRepository<BigComment, Long> {
}
