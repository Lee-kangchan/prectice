package com.future.practice.domain.board.controller;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.dto.ResponseBoardDto;
import com.future.practice.domain.board.service.BoardService;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.custom.ServerErrorException;
import com.future.practice.global.exception.custom.UserAlreadyExistException;
import com.future.practice.global.exception.custom.UserNotExistException;
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
    public ResponseEntity<ResponseDefaultDto> insertBoard(HttpSession session,BoardDto boardDto){
        try {
            if (session == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            boardService.insertBoardService(boardDto, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BOARD_INSERT_MESSAGE).build());
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException();
        }
    }

    @PutMapping("/{board_seq}")
    public ResponseEntity<ResponseDefaultDto> updateBoard(HttpSession session, @PathVariable("board_seq") int board_seq
                            ,BoardDto boardDto){
        try {
            if (session == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            boardService.updateBoardService(boardDto, board_seq, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BOARD_UPDATE_MESSAGE).build());
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException();
        }
    }

    @DeleteMapping("/{board_seq}")
    public ResponseEntity<ResponseDefaultDto> deleteBoard(HttpSession session, @PathVariable("board_seq") int board_seq){
        try {
            if (session == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            boardService.deleteBoardService(board_seq, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BOARD_DELETE_MESSAGE).build());
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException();
        }
    }

    @GetMapping("")
    public ResponseEntity<ResponseBoardDto> selectBoard(@RequestParam Map<String, Object> map){
        try {
            HttpHeaders headers = new HttpHeaders();
            ResponseBoardDto responseBoardDto;
            if (map.get("search") == null) responseBoardDto = boardService.selectBoardService(map);
            else responseBoardDto = boardService.selectSearchBoardService(map);
            return ResponseEntity.ok()
                    .headers(headers).body(responseBoardDto);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException();
        }
    }

    @GetMapping("/{board_seq}")
    public ResponseEntity<ResponseBoardDetailDto> selectBoardDetail(@PathVariable("board_seq") int board_seq){
        try {
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(boardService.selectBoardDetailService(board_seq));
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerErrorException();
        }
    }

}
