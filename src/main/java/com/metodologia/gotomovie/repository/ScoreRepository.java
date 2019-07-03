package com.metodologia.gotomovie.repository;

import com.metodologia.gotomovie.domain.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ScoreRepository extends BaseRepository{

    @Autowired
    public ScoreRepository(@Qualifier("connection1") Connection connection) { super(connection);
    }

    public void addScore(Score score) {
        String sql = "insert into scores(score,movieId) values (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,score.getScore());
            ps.setInt(2,score.getMovieId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Score> getAll() {
        String sql = "select * from scores";
        List<Score> scores = new ArrayList<Score>();
        Score s = null;
        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while (resultSet.next()) {
                s= new Score(resultSet.getInt("id"), resultSet.getInt("score"),resultSet.getInt("movieId"));
                scores.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public List<Score> getScoreByMovie(Integer movieId) {
        String sql = "select * from scores where movieId = ?";
        List<Score> scores = new ArrayList<Score>();
        Score s = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                s = new Score(rs.getInt("id"), rs.getInt("score"),rs.getInt("movieId"));
                scores.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public Float getAverageScoreByMovie(Integer movieId) {
        String sql = "select avg(score) as avg_score from scores where movieId = ? ";
        Float averageScore = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                averageScore = rs.getFloat("avg_score");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return averageScore;
    }
}
