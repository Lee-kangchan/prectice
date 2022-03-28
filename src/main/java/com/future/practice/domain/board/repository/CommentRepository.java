package com.future.practice.domain.board.repository;

import com.future.practice.global.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long > {
}
