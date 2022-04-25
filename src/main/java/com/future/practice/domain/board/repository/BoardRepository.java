package com.future.practice.domain.board.repository;

import com.future.practice.global.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    public void deleteBoardByBoardSeq(long boardSeq); // boardSeq 로 Board 데이터 삭제하기
    public Optional<Board> findBoardByBoardSeqAndBoardUserEmail(long boardSeq, String boardUserEmail); // BoardSeq, UserEmail 으로 Board 데이터 가져오기
    public Optional<Board> findBoardByBoardSeq(long boardSeq); // boardSeq 를 이용하여 Board 데이터 가져오기
    public Page<Board> findAllByBoardTitleLike(String boardTitle, Pageable pageable); // boardTitle 로 Like 문 사용한 Board 데이터 가져오기
    public Long countAllByBoardTitleLike(String boardTitle); // boardTitle 로 Like 문 사용한 Board 데이터 개수 가져오기

}
