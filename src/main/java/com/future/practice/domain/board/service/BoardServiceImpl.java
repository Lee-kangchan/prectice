package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.CommentAll;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.dto.ResponseBoardDto;
import com.future.practice.domain.board.mapper.BoardMapper;
import com.future.practice.domain.board.mapper.CommentMapper;
import com.future.practice.global.constant.Common;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;
import com.future.practice.global.entity.User;
import com.future.practice.global.exception.ErrorCode;
import com.future.practice.global.exception.custom.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;
    private final CommentMapper commentMapper;
    @Override
    public void insertBoardService(BoardDto boardDto, User user ) {
        if(boardDto.getTitle().equals("")) throw new BoardTitleNotExistException(); // 게시물 제목 없을 시
        if(boardDto.getContent().equals("")) throw new BoardContentNotExistException(); // 게시물 내용 없을 시
        boardMapper.save(boardDto.toEntity(user.getUserEmail()));
    }
    @Override
    public void updateBoardService(BoardDto boardDto, long boardSeq, User user) {
        if(boardDto.getTitle().equals("")) throw new BoardTitleNotExistException(); // 게시물 제목 없을 시
        if(boardDto.getContent().equals("")) throw new BoardContentNotExistException(); // 게시물 내용 없을 시
        boardMapper.updateByBoardSeq(boardDto.toEntity(boardSeq));
    }

    @Override
    public void deleteBoardService(long boardSeq, User user) {
        Board board = Board.builder().boardSeq(boardSeq).boardUserEmail(user.getUserEmail()).build();
        if(boardMapper.findOneByBoardSeq(boardSeq)==null ) throw new BoardNotFoundException(); // 게시물 존재 X
        if(boardMapper.findOneByBoardSeqAndBoardUserEmail(board)==null) throw new BoardNotAccessException(); // 게시물 권한 확인
        boardMapper.deleteByBoardSeq(board);
    }


    //pageing은 10개씩 --> 변경할수도?
    @Override
    public ResponseBoardDto selectBoardService(Map<String, Object> map) {
        map.put("board_num", Common.BOARD_NUM);
        if(map.get("page") ==null) map.put("page",1);

        map.put("page", (Integer.parseInt(map.get("page").toString())-1 )* Common.BOARD_NUM);
        List<Board> board = boardMapper.findAll(map);
        int page = (int)map.get("page");

        if(board.size()==0) throw new BoardNotFoundException(); // 게시물이 존재하지 않음
        return ResponseBoardDto.builder()
                .board(boardMapper.findAll(map))
                .page((int)map.get("page")) // Integer.parseInt(map.get("page").toString)
                .length(boardMapper.findAllLength(""))
                .build();
    }

    @Override
    public ResponseBoardDetailDto selectBoardDetailService(long boardSeq) {

        Board board = boardMapper.findOneByBoardSeq(boardSeq);
        if(board==null) throw new BoardNotFoundException();
        List<CommentAll> commentAll = new ArrayList<>();
        List<Comment> comment = commentMapper.findAllByCommentBoardSeq(boardSeq);
        for(Comment commentList : comment){
            commentAll.add(CommentAll.builder()
                    .comment(commentList)
                    .bigComments(commentMapper.findAllByCommentSeq(commentList.getCommentSeq()))
                    .build());
        }

        return ResponseBoardDetailDto.builder()
                .code(200)
                .board(boardMapper.findOneByBoardSeq(boardSeq))
                .commentAll(commentAll)
                .build();
    }

    @Override
    public ResponseBoardDto selectSearchBoardService(Map<String, Object> map) {
        map.put("board_num", Common.BOARD_NUM);
        if(map.get("page") ==null) map.put("page",1);
        map.put("page", (Integer.parseInt(map.get("page").toString())-1 )* Common.BOARD_NUM);
        return ResponseBoardDto
                .builder()
                .board(boardMapper.findAllByLikeSearch(map))
                .page((int)map.get("page")) // Integer.parseInt(map.get("page").toString)
                .length(boardMapper.findAllLength(map.get("search").toString()))
                .build();
    }
}
