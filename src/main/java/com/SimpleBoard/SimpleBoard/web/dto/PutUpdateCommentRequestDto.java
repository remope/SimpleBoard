package com.SimpleBoard.SimpleBoard.web.dto;

import lombok.Getter;

@Getter
public class PutUpdateCommentRequestDto {
    private String content;

    public PutUpdateCommentRequestDto(String content) {
        this.content = content;
    }
}
