package com.SimpleBoard.SimpleBoard.web.dto;

import com.SimpleBoard.SimpleBoard.domain.comment.Comment;
import com.SimpleBoard.SimpleBoard.domain.post.Post;
import com.SimpleBoard.SimpleBoard.domain.user.User;
import lombok.Getter;

@Getter
public class GetCommentListsResponseDto {
    private Long id;
    private String content;
    private Post post;
    private User author;

    public GetCommentListsResponseDto(Comment entity){
        this.id = entity.getId();
        this.content = entity.getContent();
        this.post = entity.getPost();
        this.author = entity.getAuthor();
    }
}
