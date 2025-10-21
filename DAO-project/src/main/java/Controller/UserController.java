package Controller;

import Model.User;
import Services.UserService;
import dao.DaoUserClass;
import dao.DaoUserInterface;

import java.sql.SQLException;

public class UserController {
    private UserService userService;
    private static User currentUser = null;

    public void signUp(String username, String password) {
        try {
            currentUser = userService.signUp(username, password);
        }catch (Exception e) {
            System.out.println("error");
        }
    }

    public void login(String username, String password) {
        try {
            currentUser = userService.logIn(username, password);
        }catch (Exception e) {
            System.out.println("error");
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        UserController.currentUser = currentUser;
    }
}
