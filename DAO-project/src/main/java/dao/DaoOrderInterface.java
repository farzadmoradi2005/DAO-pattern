package dao;

public interface DaoOrderInterface {
    public void SubmitOrder(String orderDetails , boolean isTakeaway , int orderPrice );
    public void editOrder(String orderDetails);
    public void cancelOrder();
}
