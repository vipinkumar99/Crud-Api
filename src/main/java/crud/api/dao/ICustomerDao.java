package crud.api.dao;

import java.util.List;

import crud.api.models.Customer;

public interface ICustomerDao {
	
	public List<Customer> getCustomerList();
	public Customer getCustomerById(int id);
	public void saveCustomer(Customer customer);
	public void updateCustomer(Customer customer);
	public void deleteCustomer(int id);
}
