package com.future.practice.domain.board.repository;

import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.QBoard;
import com.querydsl.core.annotations.Generated;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
@Generated("com.querydsl.codegen.EntitySerializer")
public class BoardQueryRepository   {

    private final JPAQueryFactory query;
    QBoard qBoard = QBoard.board;

    public List<Board> findAllByPage(){
        return query
                .selectFrom(QBoard.board)
                .fetch();
    }

}
