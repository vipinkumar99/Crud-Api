package crud.api.mappers;

import java.util.ArrayList;
import java.util.List;

import crud.api.models.Customer;
import crud.api.requests.dto.AddCustomerRequestDto;
import crud.api.requests.dto.UpdateCustomerRequestDto;
import crud.api.responses.dto.GetCustomerResponseDto;

public class CustomerMapper {

	public static List<GetCustomerResponseDto> convertEntityListToGetResponseList(List<Customer> customerList) {
		if (customerList == null)
			return null;
		List<GetCustomerResponseDto> responseList = new ArrayList<GetCustomerResponseDto>(customerList.size());

		for (Customer customer : customerList)
			responseList.add(convertEntityToGetResponse(customer));

		return responseList;
	}

	public static GetCustomerResponseDto convertEntityToGetResponse(Customer customer) {
		if (customer == null)
			return null;

		GetCustomerResponseDto response = new GetCustomerResponseDto();
		response.setCustomerId(customer.getCustomerId());
		response.setFirstName(customer.getFirstName());
		response.setLastName(customer.getLastName());
		response.setAddress(customer.getAddress());
		response.setCity(customer.getCity());
		response.setState(customer.getState());
		response.setCountry(customer.getCountry());
		response.setpostalCode(customer.getPostalCode());
		response.setPhone(customer.getPhone());
		response.setFax(customer.getFax());
		response.setEmail(customer.getEmail());

		return response;
	}

	public static Customer convertAddRequestToEntity(AddCustomerRequestDto request) {
		if (request == null)
			return null;

		Customer response = new Customer();
		response.setFirstName(request.getFirstName());
		response.setLastName(request.getLastName());
		response.setAddress(request.getAddress());
		response.setCity(request.getCity());
		response.setState(request.getState());
		response.setCountry(request.getCountry());
		response.setpostalCode(request.getPostalCode());
		response.setPhone(request.getPhone());
		response.setFax(request.getFax());
		response.setEmail(request.getEmail());

		return response;
	}

	public static Customer convertUpdateRequestToEntity(UpdateCustomerRequestDto customer) {
		if (customer == null)
			return null;

		Customer response = new Customer();
		response.setCustomerId(customer.getCustomerId());
		response.setFirstName(customer.getFirstName());
		response.setLastName(customer.getLastName());
		response.setAddress(customer.getAddress());
		response.setCity(customer.getCity());
		response.setState(customer.getState());
		response.setCountry(customer.getCountry());
		response.setpostalCode(customer.getPostalCode());
		response.setPhone(customer.getPhone());
		response.setFax(customer.getFax());
		response.setEmail(customer.getEmail());

		return response;
	}

}
