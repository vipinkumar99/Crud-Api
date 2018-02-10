package crud.api.responses.dto;

import crud.api.pojos.OrderPojo;

public class OrderResponseDto extends OrderPojo {
	
	private int orderId;

	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
}
