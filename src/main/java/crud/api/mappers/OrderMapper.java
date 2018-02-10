package crud.api.mappers;

import java.util.ArrayList;
import java.util.List;

import crud.api.models.Customer;
import crud.api.models.Order;
import crud.api.requests.dto.SaveOrderRequestDto;
import crud.api.requests.dto.UpdateOrderRequestDto;
import crud.api.responses.dto.OrderResponseDto;

public class OrderMapper {

	public static Order convertAddRequestToEntity(SaveOrderRequestDto request) {
		if(request == null) {
			return null;
		}
		Order response = new Order();
		response.setAmount(request.getAmount());
		response.setOrderDate(request.getOrderDate());
		Customer customer = new Customer();
		customer.setCustomerId(request.getCustomerId());
		response.setCustomer(customer);
		response.setProduct(request.getProduct());
		
		return response;
	}

	public static OrderResponseDto convertEntityToGetResponse(Order request) {
		if(request == null) {
			return null;
		}
		OrderResponseDto response = new OrderResponseDto();
		response.setAmount(request.getAmount());
		response.setOrderDate(request.getOrderDate());
		response.setCustomerId(request.getCustomer().getCustomerId());
		response.setProduct(request.getProduct());
		response.setOrderId(request.getOrderId());
		return response;
	}

	public static Order convertUpdateRequestToEntity(UpdateOrderRequestDto request) {
		if(request == null) {
			return null;
		}
		Order response = new Order();
		response.setOrderId(request.getOrderId());
		response.setAmount(request.getAmount());
		response.setOrderDate(request.getOrderDate());
		response.setProduct(request.getProduct());
		
		return response;
	}

	public static List<OrderResponseDto> convertEntityListToGetResponseList(List<Order> orderListToConvert) {
		if(orderListToConvert == null) {
			return null;
		}
		List<OrderResponseDto> convertedList = new ArrayList<OrderResponseDto>();
		for(Order order : orderListToConvert) {
			convertedList.add(convertEntityToGetResponse(order));
		}

		return convertedList;
	}
	
	

}
