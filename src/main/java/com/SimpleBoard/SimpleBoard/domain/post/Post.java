package com.SimpleBoard.SimpleBoard.domain.post;

import com.SimpleBoard.SimpleBoard.domain.BaseTimeEntity;
import com.SimpleBoard.SimpleBoard.domain.user.User;
import com.SimpleBoard.SimpleBoard.web.dto.PutUpdatePostRequestDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User author;

    @Builder
    public Post(String title, String content, User author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(PutUpdatePostRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }

}
