package crud.api.services;

import java.util.List;

import crud.api.exception.MyException;
import crud.api.requests.dto.SaveOrderRequestDto;
import crud.api.requests.dto.UpdateOrderRequestDto;
import crud.api.responses.dto.OrderResponseDto;

public interface IOrderService {
	
	public OrderResponseDto saveOrder(SaveOrderRequestDto request) throws MyException;
	public OrderResponseDto updateOrder(UpdateOrderRequestDto request) throws MyException;
	public boolean deleteOrder(int orderId);
	public OrderResponseDto getOrderById(int orderId);
	public List<OrderResponseDto> getAllOrders();
	public List<OrderResponseDto> getOrdersByCustomerId(int customerId);

}
