package crud.api.dao;

import java.util.List;

import crud.api.models.Order;

public interface IOrderDao {
	public void saveOrder(Order request);
	public void updateOrder(Order request);
	public void deleteOrder(int orderId);
	public Order getOrderByOrderId(int orderId);
	public List<Order> getOrdersByCustomerId(int customerId);
	public List<Order> getOrderList();
	
}
