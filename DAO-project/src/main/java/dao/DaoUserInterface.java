package dao;

import Model.User;

import java.sql.SQLException;

public interface DaoUserInterface {
    public User signUp(String username, String password) throws SQLException;
    public User signIn(String username, String password) throws SQLException;
}
