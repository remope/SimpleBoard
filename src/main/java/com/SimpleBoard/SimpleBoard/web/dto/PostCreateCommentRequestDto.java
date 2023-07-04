package com.SimpleBoard.SimpleBoard.web.dto;

import com.SimpleBoard.SimpleBoard.domain.comment.Comment;
import com.SimpleBoard.SimpleBoard.domain.post.Post;
import com.SimpleBoard.SimpleBoard.domain.user.User;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PostCreateCommentRequestDto {

    private String content;
    private Post post;
    private User author;

    @Builder
    public PostCreateCommentRequestDto(String content, Post post, User author) {
        this.content = content;
        this.post = post;
        this.author = author;
    }

    public Comment toEntity(){
        return Comment.builder()
                .content(content)
                .post(post)
                .author(author)
                .build();
    }
}
