package crud.api.utils;

import crud.api.enums.ResponseCode;
import crud.api.exception.MyException;
import crud.api.requests.dto.AddCustomerRequestDto;

public class ValidateUtils {

	public static void validateCustomerRequest(AddCustomerRequestDto request) throws Exception {
		if(request==null)
			throw new MyException(ResponseCode.INV_NAME);
		if(request.getAddress()==null);
	}
	
	
}
