package com.SimpleBoard.SimpleBoard.web.dto;

import com.SimpleBoard.SimpleBoard.domain.post.Post;
import com.SimpleBoard.SimpleBoard.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostCreatePostRequestDto {
    private String title;
    private String content;
    private User author;

    @Builder
    public PostCreatePostRequestDto(String title, String content, User author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Post toEntity(){
        return Post.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
