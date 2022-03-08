package com.future.practice.domain.board.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/v1")
public class CommentController {


    @PostMapping("/board/{board_seq}/comment")
    public void insertComment(@PathVariable("board_seq") int board_seq){

    }

    @PostMapping("/v1/comment/{comment_seq}")
    public void insertBigComment(@PathVariable("comment_seq") int comment_seq){

    }

    @DeleteMapping("/v1/comment/{comment_seq}")
    public void deleteComment(@PathVariable("comment_seq") int comment_seq){

    }

    @DeleteMapping("/v1/bigComment/{bigComment_seq}")
    public void deleteBigComment(@PathVariable("bigComment_seq") int big_comment_seq){

    }

}
