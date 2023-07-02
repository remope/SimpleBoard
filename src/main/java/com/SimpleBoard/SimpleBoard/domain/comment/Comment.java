package com.SimpleBoard.SimpleBoard.domain.comment;

import com.SimpleBoard.SimpleBoard.domain.BaseTimeEntity;
import com.SimpleBoard.SimpleBoard.domain.post.Post;
import com.SimpleBoard.SimpleBoard.domain.user.User;
import com.SimpleBoard.SimpleBoard.web.dto.PutUpdateCommentRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Comment parent;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Comment> replies = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Builder
    public Comment(String content, Post post, Comment parent, User author){
        this.content = content;
        this.post = post;
        this.parent = parent;
        this.author = author;
    }

    public void update(PutUpdateCommentRequestDto requestDto){
        this.content = requestDto.getContent();
    }


}
