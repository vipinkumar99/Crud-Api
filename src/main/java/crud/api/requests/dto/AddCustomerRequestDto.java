package crud.api.requests.dto;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

import crud.api.pojos.CustomerPojo;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(value=Include.ALWAYS)
public class AddCustomerRequestDto extends CustomerPojo{
	
	
}
