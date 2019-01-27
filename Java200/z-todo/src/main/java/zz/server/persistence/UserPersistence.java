package zz.server.persistence;

import zz.common.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserPersistence {

    public static User fromResult(ResultSet resultSet){
        User user = new User();
        try {
            user.setId(resultSet.getLong("id"));
            user.setUsername(resultSet.getString("username"));
            user.setPassword(resultSet.getString("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public User getByUsername(User user){
        Connection connection = Database.newConnection();
        String query = "SELECT * FROM \"user\" WHERE username = '" + user.getUsername() + "'";
            try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()){
                return null;
            }
            return UserPersistence.fromResult(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User create(User user){
        Connection connection = Database.newConnection();
        String query = "INSERT INTO \"user\" values (DEFAULT, '%s', '%s')RETURNING *;";
        query = String.format(query, user.getUsername(), user.getPassword());
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            if (!resultSet.next()){
                return null;
            }
            return UserPersistence.fromResult(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        UserPersistence userPersistence = new UserPersistence();
        User user = new User();
        user.setUsername("zz6");
        user.setPassword("p23");
        user = userPersistence.create(user);
        System.out.println(user);
    }
}
