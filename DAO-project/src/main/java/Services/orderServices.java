package Services;

import Model.Order;
import dao.DaoOrderInterface;

import java.sql.SQLException;

public class orderServices {
    DaoOrderInterface dao;
    public void submitOrder(Order order) throws SQLException{
        try {
            dao.SubmitOrder(order);
        } catch (Exception e) {
            throw new SQLException("error" , e);
        }
    }
}
