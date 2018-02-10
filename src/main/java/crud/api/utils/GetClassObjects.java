package crud.api.utils;

import crud.api.models.Customer;

public class GetClassObjects {

	public static Object[] CustomerObject(Customer customer) {
		Object[] obj = new Object[11];
		obj[0] = (Object)customer.getCustomerId();
		obj[1] = (Object)customer.getFirstName();
		obj[2] = (Object)customer.getLastName();
		obj[3] = (Object)customer.getAddress();
		obj[4] = (Object)customer.getCity();
		obj[5] = (Object)customer.getState();
		obj[6] = (Object)customer.getCountry();
		obj[7] = (Object)customer.getPostalCode();
		obj[9] = (Object)customer.getPhone();
		obj[9] = (Object)customer.getFax();
		obj[10] = (Object)customer.getEmail();
		
		return obj;
	}
}
