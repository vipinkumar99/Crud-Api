package crud.api.services;

import java.util.List;

import crud.api.requests.dto.AddCustomerRequestDto;
import crud.api.requests.dto.UpdateCustomerRequestDto;
import crud.api.responses.dto.GetCustomerResponseDto;


public interface ICustomerService {
	
	public List<GetCustomerResponseDto> getCustomerList();
	public GetCustomerResponseDto getCustomerById(int id);
	public GetCustomerResponseDto saveCustomer(AddCustomerRequestDto customer);
	public GetCustomerResponseDto updateCustomer(UpdateCustomerRequestDto customer);
	public boolean deleteCustomer(int id);
}
