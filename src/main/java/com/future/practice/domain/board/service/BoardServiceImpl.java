package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.CommentAll;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.mapper.BoardMapper;
import com.future.practice.domain.board.mapper.CommentMapper;
import com.future.practice.global.constant.Common;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;
import com.future.practice.global.entity.User;
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
    public void insertBoardService(BoardDto boardDto, User user) {
        log.info("userEmail: " + user.getUserEmail());
        boardMapper.save(boardDto.toEntity(user.getUserEmail()));
    }
    @Override
    public void updateBoardService(BoardDto boardDto, long boardSeq, User user) {
        boardMapper.updateByBoardSeq(boardDto.toEntity(boardSeq));
    }

    @Override
    public void deleteBoardService(long boardSeq, User user) {
        Board board = Board.builder().boardSeq(boardSeq).boardUserEmail(user.getUserEmail()).build();
        boardMapper.deleteByBoardSeq(board);
    }


    //paging은 10개씩 --> 변경할수도?
    @Override
    public List<Board> selectBoardService(Map<String, Object> map) {
        map.put("board_num", Common.BOARD_NUM);
        log.info(map.get("page").toString());
        map.put("page", (Integer.parseInt(map.get("page").toString())-1 )* Common.BOARD_NUM);

        return boardMapper.findAll(map);

    }

    @Override
    public ResponseBoardDetailDto selectBoardDetailService(long boardSeq) {

        log.info(boardMapper.findOneByBoardSeq(boardSeq).toString());

        List<CommentAll> commentAll = new ArrayList<>();
        List<Comment> comment = commentMapper.findAllByCommentBoardSeq(boardSeq);
        for(Comment commentList : comment){
            commentAll.add(CommentAll.builder()
                    .comment(commentList)
                    .bigComments(commentMapper.findAllByCommentSeq(commentList.getCommentSeq()))
                    .build());
        }

        ResponseBoardDetailDto responseBoardDetailDto
        = ResponseBoardDetailDto.builder()
                .code(200)
                .board(boardMapper.findOneByBoardSeq(boardSeq))
                .commentAll(commentAll)
                .build();
        return responseBoardDetailDto;
    }

    @Override
    public List<Board> selectSearchBoardService(Map<String, Object> map) {
        map.put("board_num", Common.BOARD_NUM);
        map.put("page", (Integer.parseInt(map.get("page").toString())-1 )* Common.BOARD_NUM);
        return boardMapper.findAllByLikeSearch(map);
    }
}
