package com.sparta.wekk043thproject.model;

import com.sparta.wekk043thproject.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String comment;

    public Comment(String comment){
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
    }

    public Long update(CommentRequestDto requestDto){
        this.comment = requestDto.getComment();
        return id;
    }

}

