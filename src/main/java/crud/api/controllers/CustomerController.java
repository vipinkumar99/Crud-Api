package crud.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import crud.api.constants.PathMappingConstants;
import crud.api.enums.ResponseCode;
import crud.api.exception.MyException;
import crud.api.requests.dto.AddCustomerRequestDto;
import crud.api.requests.dto.UpdateCustomerRequestDto;
import crud.api.responses.BaseResponse;
import crud.api.responses.dto.GetCustomerResponseDto;
import crud.api.services.ICustomerService;
import crud.api.validators.CustomerValidator;

@Controller
@RequestMapping(value = PathMappingConstants.CustomerMappings.BASE)
public class CustomerController {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(path = PathMappingConstants.ALL, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<GetCustomerResponseDto>> getAllCustomers() throws Exception {
		List<GetCustomerResponseDto> response = customerService.getCustomerList();
		if (response == null)
			throw new MyException(ResponseCode.NO_CUSTOMER_PRESERNT);
		return new BaseResponse<List<GetCustomerResponseDto>>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMappingConstants.SAVE, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<GetCustomerResponseDto> saveCustomer(@RequestBody AddCustomerRequestDto request)
			throws Exception {
		CustomerValidator.addCustomerRequestDtoValidator(request);
		GetCustomerResponseDto response = customerService.saveCustomer(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<GetCustomerResponseDto>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMappingConstants.UPDATE, method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<GetCustomerResponseDto> updateCustomer(@RequestBody UpdateCustomerRequestDto request)
			throws Exception {
		CustomerValidator.updateCustomerRequestDtoValidator(request);
		GetCustomerResponseDto response = customerService.updateCustomer(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<GetCustomerResponseDto>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMappingConstants.ID_PARAM, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<GetCustomerResponseDto> getCustomerById(
			@PathVariable(PathMappingConstants.ID) int id) throws Exception {
		GetCustomerResponseDto response = customerService.getCustomerById(id);
		if (response == null)
			throw new MyException(ResponseCode.NO_CUSTOMER_PRESERNT);

		return new BaseResponse<GetCustomerResponseDto>(false, response, ResponseCode.OK);
	}

	@RequestMapping(path = PathMappingConstants.ID_PARAM, method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<GetCustomerResponseDto> deleteCustomerById(
			@PathVariable(PathMappingConstants.ID) int id) throws Exception {
		if (!customerService.deleteCustomer(id))
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<GetCustomerResponseDto>(false, null, ResponseCode.OK);
	}

}
