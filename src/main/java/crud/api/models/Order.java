package crud.api.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Orders")
public class Order {
	
	private int orderId;
	private String orderDate;
	private String product;
	private float amount;
	private Customer customer;
	
	public Order() {
	}
	public Order(String orderDate, String product, float amount, Customer customer) {
		this.orderDate = orderDate;
		this.product = product;
		this.amount = amount;
		this.customer = customer;
	}
	
	@Id
	@Column(name="OrderId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	@ManyToOne
	@JoinColumn(name="CustomerId")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
