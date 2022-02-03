package com.sparta.wekk043thproject.model;

import com.sparta.wekk043thproject.dto.CommentRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Comment extends Timestamped{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private Long commentid;

    @Column(nullable = false)
    private String comment;

    public Comment(Long commentid,String comment){
        this.commentid = commentid;
        this.comment = comment;
    }

    public Comment(CommentRequestDto requestDto){
        this.commentid = requestDto.getCommentid();
        this.comment = requestDto.getComment();
    }

    public Long update(CommentRequestDto requestDto){
        this.commentid = requestDto.getCommentid();
        this.comment = requestDto.getComment();
        return id;
    }

}

