package com.future.practice.domain.board.controller;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.global.dto.ResponseDefaultDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/board")
public class BoardController {
    @PostMapping("")
    public ResponseDefaultDto insertBoard(){
        return null;
    }
    @PutMapping("/{board_seq}")
    public ResponseDefaultDto updateBoard(@PathVariable("board_seq") int board_seq
                            ,@RequestBody BoardDto boardDto){
        return null;
    }
    @DeleteMapping("/{board_seq}")
    public ResponseDefaultDto deleteBoard(@PathVariable("board_seq") int board_seq){
        return null;
    }
    @GetMapping("")
    public ResponseDefaultDto selectBoard(){
        return null;
    }
    @GetMapping("/{board_seq}")
    public ResponseDefaultDto selectBoardDetail(){
        return null;
    }
    @GetMapping("/search")
    public ResponseDefaultDto searchBoard(){
        return null;
    }

}
