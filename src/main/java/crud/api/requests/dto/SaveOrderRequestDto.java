package crud.api.requests.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import crud.api.pojos.OrderPojo;

@JsonInclude(value=Include.ALWAYS)
public class SaveOrderRequestDto extends OrderPojo {

	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
