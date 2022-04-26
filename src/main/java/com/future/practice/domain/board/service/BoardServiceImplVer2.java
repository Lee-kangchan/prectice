package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.CommentAll;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.dto.ResponseBoardDto;
import com.future.practice.domain.board.repository.BigCommentRepository;
import com.future.practice.domain.board.repository.BoardRepository;
import com.future.practice.domain.board.repository.CommentRepository;
import com.future.practice.global.constant.ResponseMessage;
import com.future.practice.global.dto.PageReqDto;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.ErrorCode;
import com.future.practice.global.exception.custom.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardServiceImplVer2 implements BoardService{

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final BigCommentRepository bigCommentRepository;

    @Override
    public String insertBoardService(BoardDto boardDto, User user) {
        if(boardDto.getTitle().isEmpty()) throw new BoardException(ErrorCode.BOARD_TITLE_NOT_EXIST); // 제목 X
        if(boardDto.getContent().isEmpty()) throw new BoardException(ErrorCode.BOARD_CONTENT_NOT_EXIST); // 내용 X
        boardRepository.save(boardDto.toEntity(user.getUserEmail()));

        return ResponseMessage.RESPONSE_BOARD_INSERT_MESSAGE;
    }

    @Override
    public String updateBoardService(BoardDto boardDto, long boardSeq, User user) {
        if(boardDto.getTitle().isEmpty()) throw new BoardException(ErrorCode.BOARD_TITLE_NOT_EXIST); // 제목 X
        if(boardDto.getContent().isEmpty()) throw new BoardException(ErrorCode.BOARD_CONTENT_NOT_EXIST); // 내용 X
        if(!boardRepository.findBoardByBoardSeqAndBoardUserEmail(boardSeq, boardDto.getTitle()).isPresent()) throw new BoardException(ErrorCode.BOARD_NOT_ACCESS); // 권한 X
        boardRepository.save(boardDto.toEntity(boardSeq));

        return ResponseMessage.RESPONSE_BOARD_UPDATE_MESSAGE;
    }

    @Override
    public String deleteBoardService(long boardSeq, User user) {
        if(!boardRepository.findBoardByBoardSeq(boardSeq).isPresent() ) throw new BoardNotFoundException(); // 게시물 존재 X
        if(!boardRepository.findBoardByBoardSeqAndBoardUserEmail(boardSeq,user.getUserEmail()).isPresent()) throw new BoardNotAccessException(); // 권한 X
        boardRepository.deleteBoardByBoardSeq(boardSeq);

        return ResponseMessage.RESPONSE_BOARD_DELETE_MESSAGE;
    }

    @Override
    public Page<Board> selectBoardService(PageReqDto pageReqDto) {
        Page<Board> boardPage = boardRepository.findAllByBoardTitleLike("", PageRequest.of(pageReqDto.getPage(), pageReqDto.getSize()));
        return boardPage;
    }

    @Override
    public ResponseBoardDetailDto selectBoardDetailService(long boardSeq) {
        Optional<Board> board = boardRepository.findBoardByBoardSeq(boardSeq);
        if(!board.isPresent()) throw new BoardNotFoundException();
        List<CommentAll> commentAll = new ArrayList<>();
        List<Comment> comment = commentRepository.findAllByCommentBoardSeq(boardSeq);
        for(Comment commentList : comment){
            commentAll.add(CommentAll.builder()
                    .comment(commentList)
                    .bigComments(bigCommentRepository.findAllByBigCommentCommentSeq(commentList.getCommentSeq()))
                    .build());
        }
        return ResponseBoardDetailDto.builder()
                .code(200)
                .board(board.get())
                .commentAll(commentAll)
                .build();
    }

    @Override
    public Page<Board> selectSearchBoardService(PageReqDto pageReqDto) {
        return boardRepository.findAllByBoardTitleLike(pageReqDto.getSearch(), PageRequest.of(pageReqDto.getPage(), pageReqDto.getSize()));

    }
}
