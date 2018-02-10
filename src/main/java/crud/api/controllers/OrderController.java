package crud.api.controllers;

import org.springframework.stereotype.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import crud.api.constants.PathMappingConstants;
import crud.api.enums.ResponseCode;
import crud.api.exception.MyException;
import crud.api.requests.dto.SaveOrderRequestDto;
import crud.api.requests.dto.UpdateOrderRequestDto;
import crud.api.responses.BaseResponse;
import crud.api.responses.dto.OrderResponseDto;
import crud.api.services.IOrderService;

@Controller
@RequestMapping(value = PathMappingConstants.OrderMappings.BASE)
public class OrderController {
	
	@Autowired
	IOrderService orderService;
	
	
	@RequestMapping(path=PathMappingConstants.SAVE, method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<OrderResponseDto> saveOrder(@RequestBody SaveOrderRequestDto request) throws Exception
	{
		OrderResponseDto response = orderService.saveOrder(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<OrderResponseDto>(false, response, ResponseCode.OK);
	}
	
	@RequestMapping(path=PathMappingConstants.UPDATE, method=RequestMethod.PATCH, consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<OrderResponseDto> updateOrder(@RequestBody UpdateOrderRequestDto request) throws Exception
	{
		OrderResponseDto response = orderService.updateOrder(request);
		if (response == null)
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<OrderResponseDto>(false, response, ResponseCode.OK);
	}
	
	@RequestMapping(path=PathMappingConstants.ID_PARAM, method=RequestMethod.DELETE, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<OrderResponseDto> deleteOrder(@PathVariable(PathMappingConstants.ID) int orderToDeleteId) throws Exception
	{
		if (!orderService.deleteOrder(orderToDeleteId))
			throw new MyException(ResponseCode.ERROR);
		return new BaseResponse<OrderResponseDto>(false, null, ResponseCode.OK);
	}
	
	@RequestMapping(path=PathMappingConstants.ID_PARAM, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<OrderResponseDto> getOrderById(@PathVariable(PathMappingConstants.ID) int orderToDeleteId) throws Exception
	{
		OrderResponseDto response = orderService.getOrderById(orderToDeleteId);
		if (response == null)
			throw new MyException(ResponseCode.NO_ORDER_PRESENT);
		return new BaseResponse<OrderResponseDto>(false, response, ResponseCode.OK);
	}
	
	@RequestMapping(path=PathMappingConstants.ALL, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<OrderResponseDto>> getAllOrders() throws Exception
	{
		List<OrderResponseDto> response = orderService.getAllOrders();
		if (response == null)
			throw new MyException(ResponseCode.NO_ORDER_PRESENT);
		return new BaseResponse<List<OrderResponseDto>>(false, response, ResponseCode.OK);
	}
	
	@RequestMapping(path=PathMappingConstants.OrderMappings.CUSTOMERORDER_BY_CUSTOMER_ID, method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public BaseResponse<List<OrderResponseDto>> getOrdersByCustomerId(@PathVariable(PathMappingConstants.ID) int customerId) throws Exception
	{
		List<OrderResponseDto> response = orderService.getOrdersByCustomerId(customerId);
		if (response == null)
			throw new MyException(ResponseCode.NO_ORDER_PRESENT);
		return new BaseResponse<List<OrderResponseDto>>(false, response, ResponseCode.OK);
	}
	

}
