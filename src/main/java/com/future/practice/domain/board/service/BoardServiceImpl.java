package com.future.practice.domain.board.service;

import com.future.practice.domain.board.dto.BoardDto;
import com.future.practice.domain.board.dto.CommentAll;
import com.future.practice.domain.board.dto.ResponseBoardDetailDto;
import com.future.practice.domain.board.mapper.BoardMapper;
import com.future.practice.domain.board.mapper.CommentMapper;
import com.future.practice.global.entity.Board;
import com.future.practice.global.entity.Comment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;
    private final CommentMapper commentMapper;
    @Override
    public void insertBoardService(BoardDto boardDto) {
        boardMapper.save(boardDto.toEntity());
    }
    @Override
    public void updateBoardService(BoardDto boardDto, int boardSeq) {
        boardMapper.updateByBoardSeq(boardDto.toEntity(boardSeq));
    }

    @Override
    public void deleteBoardService(int boardSeq) {
        boardMapper.deleteByBoardSeq(boardSeq);
    }


    //paging은 10개씩
    @Override
    public List<Board> selectBoardService(int page) {
        return boardMapper.findAll();

    }

    @Override
    public ResponseBoardDetailDto selectBoardDetailService(int boardSeq) {

        List<CommentAll> commentAll = new ArrayList<>();
        List<Comment> comment = commentMapper.selectComment(boardSeq);
        for(Comment commentList : comment){
            commentAll.add(CommentAll.builder().comment(commentList).bigComments(commentMapper.selectBigComment(commentList.getCommentSeq())).build());
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
        return boardMapper.findAllByLikeSearch(map);
    }
}
