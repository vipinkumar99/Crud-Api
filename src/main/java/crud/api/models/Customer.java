package crud.api.models;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="Customer")
public class Customer {
	
	@Id
	@Column(name="CustomerId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String country;
	private String postalCode;
	private String phone;
	private String fax;
	private String email;
	@OneToMany(mappedBy="customer", cascade=CascadeType.ALL,  orphanRemoval=true)
	private Set<Order> orders;
	
	public void setCustomerId(int id)
	{
		this.customerId = id;
	}
	public int getCustomerId()
	{
		return this.customerId;
	}
	public void setFirstName(String fname)
	{
		this.firstName = fname;
	}
	public String getFirstName()
	{
		return this.firstName;
	}
	public void setLastName(String lname)
	{
		this.lastName = lname;
	}
	public String getLastName()
	{
		return this.lastName;
	}
	public void setAddress(String addr)
	{
		this.address = addr;
	}
	public String getAddress()
	{
		return this.address;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getCity()
	{
		return this.city;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getState()
	{
		return this.state;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getCountry()
	{
		return this.country;
	}
	public void setpostalCode(String pcode)
	{
		this.postalCode = pcode;
	}
	public String getPostalCode()
	{
		return this.postalCode;
	}
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	public String getPhone()
	{
		return this.phone;
	}
	public void setFax(String fax)
	{
		this.fax = fax;
	}
	public String getFax()
	{
		return this.fax;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}
	
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " (" + this.email + ")";
	}

}
