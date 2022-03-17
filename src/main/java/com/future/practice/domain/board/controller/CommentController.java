package com.future.practice.domain.board.controller;

import com.future.practice.domain.board.dto.CommentDto;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.service.CommentService;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.custom.ServerErrorException;
import com.future.practice.global.exception.custom.UserNotExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequestMapping("/v1")
@Slf4j
@RequiredArgsConstructor
@RestController("")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/board/{board_seq}/comment")
    public ResponseEntity<ResponseDefaultDto> insertComment(@PathVariable("board_seq") int board_seq,
                                                            CommentDto commentDto,
                                                                        HttpSession session){
            if (session.getAttribute("user") == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            commentService.insertComment(commentDto, board_seq, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_COMMENT_INSERT_MESSAGE).build());

    }

    @PostMapping("/comment/{comment_seq}")
    public ResponseEntity<ResponseDefaultDto>  insertBigComment(@PathVariable("comment_seq") int comment_seq,
                                                                CommentDto commentDto,
                                                                HttpSession session){
            if (session.getAttribute("user") == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            commentService.insertBigComment(commentDto, comment_seq, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BIG_COMMENT_INSERT_MESSAGE).build());

    }

    @DeleteMapping("/comment/{comment_seq}")
    public ResponseEntity<ResponseDefaultDto>  deleteComment(@PathVariable("comment_seq") int comment_seq
                                                            ,HttpSession session){
            if (session.getAttribute("user") == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            commentService.deleteComment(comment_seq, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_COMMENT_DELETE_MESSAGE).build());

    }

    @DeleteMapping("/bigComment/{big_comment_seq}")
    public ResponseEntity<ResponseDefaultDto>  deleteBigComment(@PathVariable("big_comment_seq") int big_comment_seq
                                                                ,HttpSession session){
            if (session.getAttribute("user") == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            commentService.deleteBigComment(big_comment_seq, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BIG_COMMENT_DELETE_MESSAGE).build());

    }

}
