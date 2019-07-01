package com.metodologia.gotomovie.repository;

import com.metodologia.gotomovie.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CommentRepository extends BaseRepository{

    @Autowired
    public CommentRepository(@Qualifier("connection1")Connection connection) {
        super(connection);
    }

    public void addComment(Comment comment) {
        String sql = "insert into comments(comment,userId,movieId) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,comment.getComment());
            ps.setInt(2,comment.getUserId());
            ps.setInt(3,comment.getMovieId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Comment> getAll() {
        String sql = "select * from comments";
        List<Comment> comments = new ArrayList<Comment>();
        Comment comment = null;
        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while (resultSet.next()) {
                comment= new Comment(resultSet.getInt("id"), resultSet.getString("comment"),resultSet.getInt("userId"),resultSet.getInt("movieId"));
                comments.add(comment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public List<Comment> getCommentsById(Integer movieId) {
        String sql = "select * from comments where movieId = ?";
        List<Comment> comments = new ArrayList<Comment>();
        Comment c = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Comment(rs.getInt("id"), rs.getString("comment"),rs.getInt("userId"),rs.getInt("movieId"));
                comments.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }

    public List<Comment> getLatestCommentsByMovieId(Integer movieId) {
        String sql = "select * from comments where movieId = ? order by id desc limit 8";
        List<Comment> comments = new ArrayList<Comment>();
        Comment c = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                c = new Comment(rs.getInt("id"), rs.getString("comment"),rs.getInt("userId"),rs.getInt("movieId"));
                comments.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return comments;
    }
}
