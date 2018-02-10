package crud.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

import crud.api.dao.ICustomerDao;
import crud.api.models.Customer;
import crud.api.requests.dto.AddCustomerRequestDto;
import crud.api.requests.dto.UpdateCustomerRequestDto;
import crud.api.responses.dto.GetCustomerResponseDto;
import crud.api.services.ICustomerService;
import crud.api.mappers.CustomerMapper;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerDao customerDao;

	//@Override
	public List<GetCustomerResponseDto> getCustomerList() {
		return CustomerMapper.convertEntityListToGetResponseList(customerDao.getCustomerList());
	}

	//@Override
	public GetCustomerResponseDto getCustomerById(int id) {
		return CustomerMapper.convertEntityToGetResponse(customerDao.getCustomerById(id));
	}

	//@Override
	public GetCustomerResponseDto saveCustomer(AddCustomerRequestDto request) {
		Customer customer = CustomerMapper.convertAddRequestToEntity(request);
		if(customer!=null) {
			customerDao.saveCustomer(customer);
			return CustomerMapper.convertEntityToGetResponse(customer);
		}
		return null;
	}

	//@Override
	public GetCustomerResponseDto updateCustomer(UpdateCustomerRequestDto request) {
		Customer customer = CustomerMapper.convertUpdateRequestToEntity(request);
		if(customer!=null) {
			customerDao.updateCustomer(customer);
			return CustomerMapper.convertEntityToGetResponse(customer);
		}
		return null;
	}

	//@Override
	public boolean deleteCustomer(int id) {
		customerDao.deleteCustomer(id);
		return true;
	}

}
