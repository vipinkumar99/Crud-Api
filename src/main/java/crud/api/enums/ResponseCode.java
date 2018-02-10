package crud.api.enums;

public enum ResponseCode {
	OK("Success","0"),
	ERROR("Internal Server Error!","100"),
	INVALID_ARGUMENT("Argument provided is not valid", "10"),
	
	INVALID_PASSWORD("Please provide valid password!","INV_PWD"),
	
	INV_NAME("Invalid %s name","INV_NAME"),
	COMMON_CODE("",""), 
	

	NO_CUSTOMER_PRESERNT("No customer present!","NOT_FOUND"),
	NO_CUSTOMER_FIRST_NAME("Customer First Name not present", "INV_NAME"),
	NO_CUSTOMER_LAST_NAME("Customer Last Name not present", "INV_NAME"), 
	INVALID_CUSTOMER_ID("Customer Id not Valid", "INV_CUSTOMER_ID" ), 
	
	NO_ORDER_PRESENT("Order Not Present", "NOT_FOUND");
	
	;
	
	
	private String message;
	private String code;
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}

	private ResponseCode(String message, String code) {
		this.message = message;
		this.code = code;
	}
	
	public static ResponseCode formatResponseCode(final ResponseCode responseCode, String message) {
		ResponseCode commonCode = COMMON_CODE;
		commonCode.message = String.format(responseCode.message	, message);
		return commonCode;
	}
}
