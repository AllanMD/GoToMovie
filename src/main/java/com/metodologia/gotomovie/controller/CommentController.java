package com.metodologia.gotomovie.controller;

import com.metodologia.gotomovie.domain.Comment;
import com.metodologia.gotomovie.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    ViewController viewController;

    @GetMapping("")
    public List<Comment> getAll() {
        return commentService.getAll();
    }

    // @PathVariable is used to tell Spring that part of the URI path is a value you want passed to your method
    // @RequestParam: para datos que vienen de formulario
    @PostMapping("/agregar")
    public ModelAndView addComment(@RequestParam int movieId, @RequestParam String comment) {
        System.out.println("ID: " + movieId + " Comentario: " + comment);
        Comment c = new Comment();
        c.setMovieId(movieId);
        c.setComment(comment);
        c.setUserId(2); // hardcodeado por ahora, despues hay q recibirlo por parametro
        commentService.addComment(c);

        ModelAndView modelAndView = viewController.searchById(movieId);
        return modelAndView;

    }

    @GetMapping("/getByMovieID/{id}")
    public List<Comment> getByMovieId(@PathVariable Integer id) {
        return commentService.getCommentsById(id);
    }


    public List<Comment> getLatestCommentsByMovieId(Integer id){
        return commentService.getLatestCommentsByMovieId(id);
    }
}
