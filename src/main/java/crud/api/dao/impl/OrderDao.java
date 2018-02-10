package crud.api.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crud.api.dao.IOrderDao;
import crud.api.models.Order;

@Repository
@Transactional
public class OrderDao implements IOrderDao {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	//@Override
	public void saveOrder(Order request) {
		getCurrentSession().save(request);
	}

	//@Override
	public void updateOrder(Order request) {
		getCurrentSession().update(request);
	}

	//@Override
	public void deleteOrder(int orderId) {
		Order order = new Order();
		order.setOrderId(orderId);
		getCurrentSession().delete(order);
	}

	//@Override
	public Order getOrderByOrderId(int orderId) {
		return (Order) getCurrentSession().get(Order.class, orderId);
	}
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<Order> getOrdersByCustomerId(int customerId) {
		Query<Order> query = getCurrentSession().createQuery("FROM Order where customerId = :customerId");
		query.setParameter("customerId", customerId);
		List<Order> orderList = query.list();
		return orderList;
	}
	
	@SuppressWarnings("unchecked")
	//@Override
	public List<Order> getOrderList() {
		List<Order> orderList = getCurrentSession().createQuery("FROM Order").list();
		return orderList;
	}

}
