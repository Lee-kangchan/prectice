package com.future.practice.domain.board.controller;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.dto.ResponseBoardDto;
import com.future.practice.domain.board.service.BoardService;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.PageReqDto;
import com.future.practice.global.dto.ResponseDefaultDto;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.custom.ServerErrorException;
import com.future.practice.global.exception.custom.UserAlreadyExistException;
import com.future.practice.global.exception.custom.UserNotExistException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
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
    public ResponseEntity<ResponseDefaultDto> insertBoard(HttpSession session, BoardDto boardDto){
            if (session.getAttribute("user") == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");

            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(boardService.insertBoardService(boardDto, user)).build());

    }

    @PutMapping("/{board_seq}")
    public ResponseEntity<ResponseDefaultDto> updateBoard(HttpSession session, @PathVariable("board_seq") int board_seq
                            ,BoardDto boardDto){
            if (session.getAttribute("user") == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");

            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(boardService.updateBoardService(boardDto, board_seq, user)).build());
    }

    @DeleteMapping("/{board_seq}")
    public ResponseEntity<ResponseDefaultDto> deleteBoard(HttpSession session, @PathVariable("board_seq") int board_seq){
            if (session.getAttribute("user") == null) throw new UserNotExistException();
            User user = (User) session.getAttribute("user");
            boardService.deleteBoardService(board_seq, user);
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(ResponseDefaultDto.builder().code(200).message(ResponseMessage.RESPONSE_BOARD_DELETE_MESSAGE).build());
    }
    @GetMapping("")
    public ResponseEntity<Page<Board>> selectBoard(PageReqDto pageReqDto){
        log.info(pageReqDto.getSearch() +"\t"+ pageReqDto.getPage() + "\t"+ pageReqDto.getSize());

        HttpHeaders headers = new HttpHeaders();
        Page<Board> boardPage;
        if (pageReqDto.getSearch() == null) boardPage = boardService.selectBoardService(pageReqDto);
        else boardPage = boardService.selectSearchBoardService(pageReqDto);
        return ResponseEntity.ok()
                .headers(headers).body(boardPage);

    }

    @GetMapping("/{board_seq}")
    public ResponseEntity<ResponseBoardDetailDto> selectBoardDetail(@PathVariable("board_seq") int board_seq){
            HttpHeaders headers = new HttpHeaders();
            return ResponseEntity.ok()
                    .headers(headers)
                    .body(boardService.selectBoardDetailService(board_seq));
    }

}
