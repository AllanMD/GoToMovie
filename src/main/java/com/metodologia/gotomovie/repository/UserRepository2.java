package com.metodologia.gotomovie.repository;

import com.metodologia.gotomovie.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository2 extends BaseRepository {

    @Autowired
    public UserRepository2(@Qualifier("connection1")Connection connection) {
        super(connection);
    }

    public void addUser(User user) throws SQLException {
        String sql = "insert into users(name,lastName,userName,password) values (?,?,?,?)";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setString(1,user.getName());
        ps.setString(2,user.getLastName());
        ps.setString(3,user.getUserName());
        ps.setString(4,user.getPassword());
        ps.executeUpdate();
    }

    public List<User> getAll() {
        String sql = "select * from users";
        List<User> users = new ArrayList<User>();
        User user = null;
        try {
            Statement stm = connection.createStatement();
            ResultSet resultSet = stm.executeQuery(sql);
            while (resultSet.next()) {
                user = new User(resultSet.getInt("id"),resultSet.getString("name"), resultSet.getString("lastName"),resultSet.getString("userName"),resultSet.getString("password"));
                System.out.println(user.toString());
                users.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
