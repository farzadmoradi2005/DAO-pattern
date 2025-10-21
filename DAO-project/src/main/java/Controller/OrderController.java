package Controller;

import Model.Order;
import Services.ServiceExeption;
import Services.orderServices;
import dao.DaoOrderClass;
import dao.DaoOrderInterface;

import java.sql.SQLException;
import java.time.Duration;
import java.time.LocalDateTime;

public class OrderController {
    private Order order;
    private orderServices os = new orderServices();
    public void SubmitOrder(String orderDetails , boolean isTakeaway , int orderPrice ) throws SQLException{
        order = new Order(orderDetails, isTakeaway, orderPrice);
        order.setUser(UserController.getCurrentUser());
        try{
        os.submitOrder(order);}
        catch (ServiceExeption e){
            System.out.println(e.getMessage());
        }
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
