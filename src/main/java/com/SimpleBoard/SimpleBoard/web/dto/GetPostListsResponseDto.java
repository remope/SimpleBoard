package com.SimpleBoard.SimpleBoard.web.dto;

import com.SimpleBoard.SimpleBoard.domain.post.Post;
import com.SimpleBoard.SimpleBoard.domain.user.User;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class GetPostListsResponseDto {

    private Long id;
    private String title;
    private String content;
    private User author;
    private LocalDateTime localDateTime;

    public GetPostListsResponseDto(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.localDateTime = entity.getModifiedAt();
    }
}
