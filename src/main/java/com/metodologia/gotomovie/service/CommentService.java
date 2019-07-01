package com.metodologia.gotomovie.service;

import com.metodologia.gotomovie.domain.Comment;
import com.metodologia.gotomovie.repository.CommentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void addComment(Comment extraMovie) {
        commentRepository.addComment(extraMovie);
    }

    public List<Comment> getAll() {
        return commentRepository.getAll();
    }

    public List<Comment> getCommentsById(Integer movieId) {
        List<Comment> comments = commentRepository.getCommentsById(movieId);
        return (comments.size() > 0) ? comments : null;
    }

    public List<Comment> getLatestCommentsByMovieId(Integer movieId){
        List<Comment> comments = commentRepository.getLatestCommentsByMovieId(movieId);
        return comments;
    }
}
