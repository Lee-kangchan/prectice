//package com.future.practice.domain.board.service;
//
//import com.future.practice.domain.board.dto.BoardDto;
//import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
//import com.future.practice.domain.board.dto.ResponseBoardDto;
//import com.future.practice.domain.user.dto.UserDto;
//import com.future.practice.global.entity.Board;
//import com.future.practice.global.entity.User;
//import lombok.extern.slf4j.Slf4j;
//import org.junit.Test;
//import org.junit.jupiter.api.DisplayName;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.mock.web.MockHttpSession;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotEquals;
//
//@SpringBootTest
//@Slf4j
//public class boardServiceTest {
//
//    @Autowired
//    private BoardService boardService;
//
//
//    @Test
//    @DisplayName("게시물 조회")
//    void selectBoardTest(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("page",1);
//
//        ResponseBoardDto boardDto = boardService.selectBoardService(map);
//
//        assertNotEquals(boardDto.getBoard().size(), 0);
//    }
//
//    @Test
//    @DisplayName("게시물 상세 조회")
//    void selectBoardDetailTest(){
//        ResponseBoardDetailDto boardDetailDto = boardService.selectBoardDetailService(10);
//
//        assertEquals(boardDetailDto.getBoard().getBoardTitle(), "he23432llo");
//        assertEquals(boardDetailDto.getBoard().getBoardContent(), "wo5v2343rsld");
//    }
//
//    @Test
//    @DisplayName("게시물 검색 조회")
//    void selectBoardSearchTest(){
//        Map<String, Object> map = new HashMap<>();
//        map.put("page",1);
//        map.put("search","h");
//
//        ResponseBoardDto boardDto = boardService.selectBoardService(map);
//        assertNotEquals(boardDto.getBoard().size(), 0);
//    }
//
//    @Test
//    @DisplayName("게시물 입력")
//    void insertBoardTest(){
//        BoardDto board = BoardDto.builder().title("Test").content("Test 입니다").build();
//        User user = User.builder().userEmail("abc@naver.com").build();
//        boardService.insertBoardService(board,user);
//    }
//
//    @Test
//    @DisplayName("게시물 수정")
//    void updateBoardTest(){
//        BoardDto board = BoardDto.builder().title("Test").content("Test 입니다").build();
//        User user = User.builder().userEmail("abc@naver.com").build();
//        long board_seq = 12;
//
//        boardService.updateBoardService(board, board_seq, user );
//    }
//    @Test
//    @DisplayName("게시물 삭제")
//    void deleteTest(){
//        User user = User.builder().userEmail("abc@naver.com").build();
//        long board_seq = 12;
//
//        boardService.deleteBoardService(board_seq, user);
//    }
//
//}
