package com.SimpleBoard.SimpleBoard.domain.post;

import com.SimpleBoard.SimpleBoard.domain.BaseTimeEntity;
import com.SimpleBoard.SimpleBoard.domain.user.User;
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
    private User user;

    @Builder
    public Post(String title, String content, User user){
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
