package crud.api.requests.dto;

import crud.api.pojos.OrderPojo;

public class UpdateOrderRequestDto extends OrderPojo {
	
	private int orderId;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

}
