package Services;

import Model.User;
import dao.DaoUserInterface;

import java.sql.SQLException;

public class UserService {
    DaoUserInterface daoUserInterface ;
    public User signUp(String username, String password) throws ServiceExeption {
        try {
            return daoUserInterface.signUp(username , password);
        }catch (Exception e) {
            throw new ServiceExeption("error");
        }
    }
    public User logIn(String username, String password) throws ServiceExeption {
        try {
            return daoUserInterface.signIn(username , password);
        }catch (Exception e) {
            throw new ServiceExeption("error");
        }
    }
}
