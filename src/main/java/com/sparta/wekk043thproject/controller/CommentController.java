package com.sparta.wekk043thproject.controller;

import com.sparta.wekk043thproject.dto.CommentRequestDto;
import com.sparta.wekk043thproject.model.Board;
import com.sparta.wekk043thproject.model.Comment;
import com.sparta.wekk043thproject.repository.CommentRepository;
import com.sparta.wekk043thproject.service.CommentService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {
    private final CommentRepository commentRepository;
    private final CommentService commentService;

    //댓글 생성하기
    @PostMapping("api/comments")
    public Comment createComment(@RequestBody CommentRequestDto requestDto){
        Comment comment = new Comment(requestDto);
        return commentRepository.save(comment);
    }
    //댓글 조회하기 -> @Controller로 들어갈 수 있음.
    @GetMapping("/api/comments")
    public List<Comment> readComment(){
        return commentRepository.findAllByOrderByModifiedAtDesc();
    }

    //댓글 변경하기
    @PutMapping("/api/comments/{id}")
    public Long updatecomment(@PathVariable Long id, @RequestBody CommentRequestDto requestDto){
        commentService.update(id,requestDto);
        return id;
    }

    //댓글 삭제하기
    @DeleteMapping("/api/comments/{id}")
    //@PathVariable : 주소에 있는 아이디를 변수로 받기 위해, 경로에 있는 변수.
    public Long deleteComment(@PathVariable Long id){
        commentRepository.deleteById(id);
        return id;
    }
}
