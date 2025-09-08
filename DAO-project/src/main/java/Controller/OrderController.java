package Controller;

import Model.Order;
import dao.DaoOrderClass;
import dao.DaoOrderInterface;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

public class OrderController {
    private Order order;
    private DaoOrderInterface dao = new DaoOrderClass();
    public void SubmitOrder(String orderDetails , boolean isTakeaway , int orderPrice ) throws SQLException{
        order = new Order(orderDetails, isTakeaway, orderPrice);
        order.setUser(UserController.getCurrentUser());
        dao.SubmitOrder(order);
    }
    public int showOrderID(){
        return order.getOrderId();
    }
    public void editOrder(String orderDetails) throws SQLException {

        if (Duration.between(order.getOrderDate(), LocalDateTime.now()).toMinutes() < 10) {
            dao.editOrder(orderDetails , order);
        }
    }
    public void cancelOrder() throws SQLException{
        dao.cancelOrder(order);
    }
}
