package crud.api.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import crud.api.dao.ICustomerDao;
import crud.api.models.Customer;

@Repository
@Transactional
public class CustomerDao implements ICustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
//	@Override
	public List<Customer> getCustomerList() {
		List<Customer> customerList = null;
		customerList = getCurrentSession().createQuery("FROM Customer").list();
		return customerList;
	}

	//@Override
	public Customer getCustomerById(int id) {
		return (Customer) getCurrentSession().get(Customer.class, id);
	}

	//@Override
	public void saveCustomer(Customer customer) {
		getCurrentSession().save(customer);
	}

	//@Override
	public void updateCustomer(Customer customer) {
		getCurrentSession().update(customer);
	}

	//@Override
	public void deleteCustomer(int id) {
		Customer customer = getCustomerById(id);
		getCurrentSession().delete(customer);
	}

}
