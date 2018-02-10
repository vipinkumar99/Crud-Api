package crud.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import crud.api.dao.ICustomerDao;
import crud.api.dao.IOrderDao;
import crud.api.enums.ResponseCode;
import crud.api.exception.MyException;
import crud.api.mappers.OrderMapper;
import crud.api.models.Customer;
import crud.api.models.Order;
import crud.api.requests.dto.SaveOrderRequestDto;
import crud.api.requests.dto.UpdateOrderRequestDto;
import crud.api.responses.dto.OrderResponseDto;
import crud.api.services.IOrderService;

@Service
public class OrderService implements IOrderService {
	
	@Autowired
	ICustomerDao customerDao;
	@Autowired
	IOrderDao orderDao;

	//@Override
	public OrderResponseDto saveOrder(SaveOrderRequestDto request) throws MyException {
		Order order = OrderMapper.convertAddRequestToEntity(request);
		if(order != null) {
			if(customerDao.getCustomerById(request.getCustomerId()) == null) {
				throw new MyException(ResponseCode.NO_CUSTOMER_PRESERNT);
			}
			orderDao.saveOrder(order);
			return OrderMapper.convertEntityToGetResponse(order);
		}
		return null;
	}

	//@Override
	public OrderResponseDto updateOrder(UpdateOrderRequestDto request) throws MyException {
		Order orderToUpdate = OrderMapper.convertUpdateRequestToEntity(request);
		if(orderToUpdate != null) {
			Customer customer = orderDao.getOrderByOrderId(orderToUpdate.getOrderId()).getCustomer();
			orderToUpdate.setCustomer(customer);
			orderDao.updateOrder(orderToUpdate);
			return OrderMapper.convertEntityToGetResponse(orderToUpdate);
		}
		return null;
	}

	//@Override
	public boolean deleteOrder(int orderId) {
		orderDao.deleteOrder(orderId);
		return true;
	}
	
	//@Override
	public OrderResponseDto getOrderById(int orderId) {
		return OrderMapper.convertEntityToGetResponse(orderDao.getOrderByOrderId(orderId));
	}

	//@Override
	public List<OrderResponseDto> getAllOrders() {
		return OrderMapper.convertEntityListToGetResponseList(orderDao.getOrderList());
	}

	//@Override
	public List<OrderResponseDto> getOrdersByCustomerId(int customerId) {
		return OrderMapper.convertEntityListToGetResponseList(orderDao.getOrdersByCustomerId(customerId));
	}

}
