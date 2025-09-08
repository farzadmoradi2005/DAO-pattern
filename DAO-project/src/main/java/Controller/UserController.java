package Controller;

import Model.User;
import dao.DaoUserClass;
import dao.DaoUserInterface;

import java.sql.SQLException;

public class UserController {
    private DaoUserInterface dao = new DaoUserClass();
    private static User currentUser = null;

    public void signUp(String username, String password) throws SQLException {
        currentUser = dao.signUp(username, password);
    }

    public void login(String username, String password) throws SQLException {
        currentUser = dao.signUp(username, password);
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserController.currentUser = currentUser;
    }
}
