package crud.api.validators;

import crud.api.enums.ResponseCode;
import crud.api.exception.MyException;
import crud.api.requests.dto.AddCustomerRequestDto;
import crud.api.requests.dto.UpdateCustomerRequestDto;

import org.springframework.util.StringUtils;

public class CustomerValidator {
	
	public static void addCustomerRequestDtoValidator(AddCustomerRequestDto customerToValidate) throws MyException
	{
		if(customerToValidate == null) {
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}
			
		if(StringUtils.isEmpty(customerToValidate.getFirstName())) {
			throw new MyException(ResponseCode.NO_CUSTOMER_FIRST_NAME);
		}
		if(StringUtils.isEmpty(customerToValidate.getLastName())) {
			throw new MyException(ResponseCode.NO_CUSTOMER_LAST_NAME);
		}
	}

	public static void updateCustomerRequestDtoValidator(UpdateCustomerRequestDto customerToValidate) throws MyException {
		if(customerToValidate == null) {
			System.out.println("Null Error");
			throw new MyException(ResponseCode.INVALID_ARGUMENT);
		}
		
		if(customerToValidate.getCustomerId() <= 0)
			throw new MyException(ResponseCode.INVALID_CUSTOMER_ID);
	}

}
