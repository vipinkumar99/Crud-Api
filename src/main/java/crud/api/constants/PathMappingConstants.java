package crud.api.constants;

public interface PathMappingConstants {

	String BASE = "/";
	String ALL = "/all";
	String SAVE = "/save";
	String UPDATE = "/update";
	String ID = "id";
	String ID_PARAM = "/{" + ID + "}";

	interface CustomerMappings {
		String BASE = "/customers";
	}

	interface OrderMappings {
		String BASE = "/order";
		String CUSTOMERORDER_BY_CUSTOMER_ID = "/customer" + ID_PARAM;
	}

}
