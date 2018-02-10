package crud.api.requests.dto;

public class UpdateCustomerRequestDto extends AddCustomerRequestDto {

	private int customerId;
	
	public int getCustomerId() {
		return customerId;
	}
	
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
}
