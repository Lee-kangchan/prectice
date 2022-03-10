package com.future.practice.domain.board.dto;


import com.future.practice.global.entity.BigComment;
import com.future.practice.global.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentAll{
    private Comment comment;
    private List<BigComment> bigComments;
}