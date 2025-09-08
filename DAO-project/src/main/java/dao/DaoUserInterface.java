package dao;

import Model.User;

public interface DaoUserInterface {
    public void signUp(String username, String password);
    public void signIn(String username, String password);
}
