package dao;

import Model.Order;

import java.sql.SQLException;

public interface DaoOrderInterface {
    public void SubmitOrder(Order order) throws SQLException;
    public void editOrder(String orderDetails , Order order) throws SQLException;
    public void cancelOrder(Order order) throws SQLException;
}
