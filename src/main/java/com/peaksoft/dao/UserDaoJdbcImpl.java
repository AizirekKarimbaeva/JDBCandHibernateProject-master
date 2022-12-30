package com.peaksoft.dao;



import com.peaksoft.model.User;
import com.peaksoft.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJdbcImpl implements UserDao {

    public UserDaoJdbcImpl() {

    }

    public void createUsersTable() {
        String SQL = "CREATE TABLE IF NOT EXISTS users(" +
                "id SERIAL PRIMARY KEY," +
                "name VARCHAR(100)," +
                "lastName VARCHAR(100)," +
                "age VARCHAR(50))";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS users;";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String SQL = "INSERT INTO users (name,lastName,age) VALUES (?,?,?);";
        try (Connection conn = Util.connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String SQL = "DELETE FROM users WHERE id = ?;";
        try (Connection conn = Util.connection();
             PreparedStatement statement = conn.prepareStatement(SQL)) {
            statement.setLong(1,id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers(){
    String SQL = "SELECT * FROM users;";
    List<User> countryList = new ArrayList<>();
        try (Connection conn = Util.connection();
    Statement statement = conn.createStatement();
    ResultSet resultSet = statement.executeQuery(SQL)) {
        while (resultSet.next()) {
            User user = new User();
            user.setId(resultSet.getLong("id"));
            user.setName(resultSet.getString("name"));
            user.setLastName(resultSet.getString("lastName"));
            user.setAge(resultSet.getByte("age"));
            countryList.add(user);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
        return countryList;
}
    public void cleanUsersTable() {
        String SQL = "TRUNCATE TABLE users;";
        try (Connection conn = Util.connection();
             Statement statement = conn.createStatement()) {
            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    }
