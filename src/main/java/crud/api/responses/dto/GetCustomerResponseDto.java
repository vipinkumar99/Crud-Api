package crud.api.responses.dto;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import crud.api.pojos.CustomerPojo;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(value=Include.ALWAYS)
public class GetCustomerResponseDto extends CustomerPojo{
	
	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
