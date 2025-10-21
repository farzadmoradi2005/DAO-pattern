package Services;

import Model.Order;
import dao.DaoOrderInterface;

import java.sql.SQLException;

public class orderServices {
    DaoOrderInterface dao;
    public void submitOrder(Order order) throws ServiceExeption{
        try {
            dao.SubmitOrder(order);
        } catch (Exception e) {
            throw new ServiceExeption("error");
        }
    }
    public void editOrder(String orderDetails, Order order) throws ServiceExeption{
        try {
            dao.editOrder(orderDetails , order);
        }catch (Exception e){
            throw new ServiceExeption("error");
        }
    }
    public void cancelOrder(Order order) throws ServiceExeption{
        try {
            dao.cancelOrder(order);
        }catch (Exception e){
            throw new ServiceExeption("error");
        }
    }
}
