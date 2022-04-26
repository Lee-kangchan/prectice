package com.future.practice.global.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageReqDto {
    private Integer page;
    private Integer size;
    private String search;
}
