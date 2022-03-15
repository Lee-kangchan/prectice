package com.future.practice.domain.comment.service;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.CommentDto;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.dto.ResponseBoardDto;
import com.future.practice.domain.board.service.BoardService;
import com.future.practice.domain.board.service.CommentService;
import com.future.practice.global.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@SpringBootTest
@Slf4j
public class commentServiceTest {

    @Autowired
    private CommentService commentService;

    @Test
    @DisplayName("댓글 입력")
    void insertCommentTest(){

        CommentDto commentDto = CommentDto.builder().content("Test Comment").build();
        long board_seq = 12;
        User user = User.builder().userEmail("abc@naver.com").build();
        commentService.insertComment(commentDto, board_seq, user);

    }

    @Test
    @DisplayName("대댓글 입력")
    void insertBigCommentTest(){
        CommentDto commentDto = CommentDto.builder().content("Test Comment").build();
        long comment_seq = 2;
        User user = User.builder().userEmail("abc@naver.com").build();
        commentService.insertBigComment(commentDto, comment_seq, user);

    }

    @Test
    @DisplayName("댓글 삭제")
    void deleteCommentTest(){
        long comment_seq = 1;
        User user = User.builder().userEmail("abc@naver.com").build();

        commentService.deleteComment(comment_seq,user);
    }

    @Test
    @DisplayName("대댓글 삭제")
    void deleteBigCommentTest(){
        long big_comment_seq = 1;
        User user = User.builder().userEmail("abc@naver.com").build();

        commentService.deleteBigComment(big_comment_seq, user);
    }

}
