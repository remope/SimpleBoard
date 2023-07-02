package com.SimpleBoard.SimpleBoard.web.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PutUpdatePostRequestDto {
    private String title;
    private String content;

    public PutUpdatePostRequestDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
