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
    private Comment parent;
    private User author;

    @Builder
    public PostCreateCommentRequestDto(String content, Post post, Comment parent, User author) {
        this.content = content;
        this.post = post;
        this.parent = parent;
        this.author = author;
    }

    public Comment toEntity(){
        return Comment.builder()
                .content(content)
                .post(post)
                .parent(parent)
                .author(author)
                .build();
    }
}
