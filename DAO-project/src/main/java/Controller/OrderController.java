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
    public void SubmitOrder(String orderDetails , boolean isTakeaway , int orderPrice ){
        order = new Order(orderDetails, isTakeaway, orderPrice);
        order.setUser(UserController.getCurrentUser());
        try{
        os.submitOrder(order);
        }
        catch (ServiceExeption  e){
            System.out.println(e.getMessage());
        }
    }
    public int showOrderID(){
        return order.getOrderId();
    }
    public void editOrder(String orderDetails) {
        try {

            if (Duration.between(order.getOrderDate(), LocalDateTime.now()).toMinutes() < 10) {
                os.editOrder(orderDetails, order);
            }
        }catch (ServiceExeption e){
            System.out.println(e.getMessage());
        }
    }
    public void cancelOrder(){
        try {
            os.cancelOrder(order);
        }catch (ServiceExeption e){
            System.out.println(e.getMessage());
        }
    }
}
