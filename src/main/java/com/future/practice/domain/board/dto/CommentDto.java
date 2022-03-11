package com.future.practice.domain.board.dto;

import com.future.practice.global.entity.BigComment;
import com.future.practice.global.entity.Comment;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class CommentDto {
    private String content;

    public Comment toCommentEntity(long board_seq, String email){
        LocalDateTime time = LocalDateTime.now();
        return Comment.builder()
                .commentContent(content)
                .commentCreatedAt(time)
                .commentModifiedAt(time)
                .commentBoardSeq(board_seq)
                .commentUserEmail(email)
                .build();
    }
    public BigComment toBigCommentEntity(long board_seq, String email){
        LocalDateTime time = LocalDateTime.now();
        return BigComment.builder()
                .bigCommentContent(content)
                .bigCommentCreatedAt(time)
                .bigCommentModifiedAt(time)
                .bigCommentCommentSeq(board_seq)
                .bigCommentUserEmail(email)
                .build();
    }
}
