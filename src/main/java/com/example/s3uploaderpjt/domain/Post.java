package com.example.s3uploaderpjt.domain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "post")
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "post", orphanRemoval = true)
    private List<Likes> likeses = new ArrayList<>();

    public void setLikeses(List<Likes> likeses) {
        this.likeses = likeses;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setUser(User user) {
        this.user = user;
    }
}