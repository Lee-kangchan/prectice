package com.future.practice.domain.board.controller;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.service.BoardService;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/v1/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;
    @PostMapping("")
    public ResponseEntity<ResponseDefaultDto> insertBoard(HttpSession session, @RequestBody BoardDto boardDto){
        HttpHeaders headers = new HttpHeaders();
        User user = (User)session.getAttribute("user");

        boardService.insertBoardService(boardDto, user);
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BOARD_INSERT_MESSAGE).build());
    }

    @PutMapping("/{board_seq}")
    public ResponseEntity<ResponseDefaultDto> updateBoard(HttpSession session, @PathVariable("board_seq") int board_seq
                            ,@RequestBody BoardDto boardDto){
        User user = (User)session.getAttribute("user");
        boardService.updateBoardService(boardDto, board_seq, user);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BOARD_UPDATE_MESSAGE).build());
    }

    @DeleteMapping("/{board_seq}")
    public ResponseEntity<ResponseDefaultDto> deleteBoard(HttpSession session, @PathVariable("board_seq") int board_seq){
        User user = (User)session.getAttribute("user");
        boardService.deleteBoardService(board_seq, user);
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BOARD_DELETE_MESSAGE).build());
    }

    @GetMapping("")
    public ResponseEntity<List<Board>> selectBoard(@RequestParam Map<String, Object> map){

        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers).body(boardService.selectBoardService(map));
    }

    @GetMapping("/{board_seq}")
    public ResponseEntity<ResponseBoardDetailDto> selectBoardDetail(@PathVariable("board_seq") int board_seq){
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(boardService.selectBoardDetailService(board_seq));
    }
    @GetMapping("/search")
    public ResponseEntity<List<Board>> searchBoard(@RequestParam Map<String, Object> paramMap){  // search, page 값
        HttpHeaders headers = new HttpHeaders();
        return ResponseEntity.ok()
                .headers(headers)
                .body(boardService.selectSearchBoardService(paramMap));
    }

}
