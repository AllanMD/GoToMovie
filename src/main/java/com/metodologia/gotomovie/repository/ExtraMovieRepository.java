package com.metodologia.gotomovie.repository;

import com.metodologia.gotomovie.domain.ExtraMovie;
import com.metodologia.gotomovie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ExtraMovieRepository extends BaseRepository{

    @Autowired
    public ExtraMovieRepository(@Qualifier("connection1")Connection connection) {
        super(connection);
    }

    public void addExtraMovie(ExtraMovie extraMovie) {
        String sql = "insert into extraMovie(comentario,userId,puntuacion,movieId) values (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,extraMovie.getComentario());
            ps.setInt(2,extraMovie.getUserId());
            ps.setDouble(3,extraMovie.getPuntuacion());
            ps.setInt(4,extraMovie.getMovieId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ExtraMovie> getAll() {
        String sql = "select * from extraMovie";
        List<ExtraMovie> extraMovies = new ArrayList<ExtraMovie>();
        ExtraMovie extraMovie = null;
        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while (resultSet.next()) {
                extraMovie= new ExtraMovie(resultSet.getInt("id"),resultSet.getDouble("puntuacion"), resultSet.getString("comentario"),resultSet.getInt("userId"),resultSet.getInt("movieId"));
                extraMovies.add(extraMovie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extraMovies;
    }

    public List<ExtraMovie> getMovieExtraById(Integer movieId) {
        String sql = "select * from extraMovie where movieId = ?";
        List<ExtraMovie> extraMovies = new ArrayList<ExtraMovie>();
        ExtraMovie extraMovie = null;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,movieId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                extraMovie = new ExtraMovie(rs.getInt("id"),rs.getDouble("puntuacion"), rs.getString("comentario"),rs.getInt("userId"),rs.getInt("movieId"));
                extraMovies.add(extraMovie);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return extraMovies;
    }
}
