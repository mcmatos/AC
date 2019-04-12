package org.academiadecodigo.bootcamp.service;

import org.academiadecodigo.bootcamp.model.User;
import org.academiadecodigo.bootcamp.utils.Security;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class JdbcUserService implements UserService{

    private Connection dbConnection;

    @Override
    public boolean authenticate(String username, String password) {

        Boolean auth = false;
        PreparedStatement statement = null;

        try{
            String query = "SELECT * FROM user WHERE username=? AND password=?;";
            statement = dbConnection.prepareStatement(query);

            statement.setString(1, username);
            statement.setString(2, Security.getHash(password));

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                auth = true;

        } catch (SQLException e) {
            System.err.println(e.getErrorCode());

        } finally {
            try {
                if (statement != null)
                    statement.close();

            } catch (SQLException e) {
                System.err.println(e.getErrorCode());
            }
        }
        return auth;
    }

    @Override
    public void add(User user) {

        PreparedStatement statement = null;

        try {
            String query = "INSERT INTO user(username, email, password, firstname, lastname, phone) VALUES " +
                    "(?, ?, ?, ?, ?, ?);";

            statement = dbConnection.prepareStatement(query);

            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getFirstName());
            statement.setString(5, user.getLastName());
            statement.setString(6, user.getPhone());

            statement.executeUpdate();

        } catch (SQLException e) {

            if (e.getErrorCode() == 1062) {
                System.out.println("Username already exists (error: 1062)");
                return;
            }
            System.err.println(e.getErrorCode());

        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                System.err.println(e.getErrorCode());
            }
        }
    }

    @Override
    public User findByName(String username) {

        User user = null;
        PreparedStatement statement = null;

        try {
            String query = "SELECT * FROM user WHERE username=?;";

            statement = dbConnection.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = new User(resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("phone"));
            }
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());

        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                System.err.println(e.getErrorCode());
            }
        }
        return user;
    }

    @Override
    public List<User> findAll() {


        LinkedList<User> list = new LinkedList<>();
        PreparedStatement statement = null;

        try {
            String query = "SELECT * FROM user;";

            statement = dbConnection.prepareStatement(query);

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                list.add(new User(resultSet.getString("username"), resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getString("firstname"), resultSet.getString("lastname"), resultSet.getString("phone")));
            }
        } catch (SQLException e) {
            System.err.println(e.getErrorCode());

        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                System.err.println(e.getErrorCode());
            }
        }
        return list;
    }

    @Override
    public int count() {

        Statement statement = null;
        int result = 0;

        try {
            String query = "SELECT COUNT(*) FROM user";

            statement = dbConnection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                result = resultSet.getInt(1);
            }
            statement.close();

        } catch (SQLException e) {
            System.err.println(e.getErrorCode());

        } finally {
            try {
                if (statement != null)
                    statement.close();
            } catch (SQLException e) {
                System.err.println(e.getErrorCode());
            }
        }
        return result;
    }

    public void setDbConnection(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }
}
