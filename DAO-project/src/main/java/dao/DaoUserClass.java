package dao;

import Model.User;

import java.sql.*;

public class DaoUserClass implements DaoUserInterface {
    @Override
    public User signUp(String username, String password) throws SQLException{
        String URL = "jdbc:postgresql://localhost:5432/Restaurant_Order";
        String USER = "RestaurantAdmin";
        String PASS = "RestaurantAdmin";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "INSERT INTO users (username, password) VALUES (?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ps.executeUpdate();
        con.close();
        return new User(username, password);
    }
    @Override
    public User signIn(String username, String password) throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/Restaurant_Order";
        String USER = "RestaurantAdmin";
        String PASS = "RestaurantAdmin";
        Connection con = DriverManager.getConnection(URL, USER, PASS);
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            con.close();
            return new User(rs.getString("username"), rs.getString("password"));
        }
        con.close();
        return null;
    }
}
