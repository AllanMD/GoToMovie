package com.metodologia.gotomovie.repository;

import com.metodologia.gotomovie.domain.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ActorRepository2 extends BaseRepository {

    @Autowired
    public ActorRepository2(@Qualifier("connection1") Connection connection){
        super(connection);
    }

    public void addActor(Actor actor) {
        String sql = "INSERT INTO actors(name,lastName) VALUES (?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,actor.getName());
            ps.setString(2,actor.getLastName());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocurrio un error al intentar agregar el nuevo actor");
        }
    }

    public List<Actor> getAll() {
        String sql = "SELECT * FROM actors";
        List<Actor> actors = new ArrayList<Actor>();
        Actor actor = null;
        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while (resultSet.next()) {
                actor = new Actor(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("lastName"));
                actors.add(actor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocurrio un error al leer los actores");
        }
        return actors;
    }
}
