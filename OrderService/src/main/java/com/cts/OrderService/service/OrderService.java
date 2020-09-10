package com.cts.OrderService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.OrderService.DTO.OrderDTO;
import com.cts.OrderService.model.OrderAccessoryDetails;
import com.cts.OrderService.model.OrderColorDetails;
import com.cts.OrderService.model.OrderDetails;
import com.cts.OrderService.repository.AccessoryRepository;
import com.cts.OrderService.repository.ColorRepository;
import com.cts.OrderService.repository.ModelRepository;
import com.cts.OrderService.repository.OrderAccessoryDetailsRepository;
import com.cts.OrderService.repository.OrderColorDetailsRepository;
import com.cts.OrderService.repository.OrderDetailsRepository;
import com.cts.model.User;


@Service
public class OrderService {
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;	
	@Autowired
	private OrderColorDetailsRepository orderColorDetailsRepository;
	@Autowired
	private OrderAccessoryDetailsRepository orderAccessoryDetailsRepository;
	
	

	public void placeOrder(@RequestBody OrderDTO orderDTO) {
		OrderDetails od = new OrderDetails();
		od.setUserId(orderDTO.getUserId());
		od.setSeriesId(orderDTO.getSeriesId());
		od.setSeriesName(orderDTO.getSeriesName());
		od.setModelId(orderDTO.getModelId());
		od.setModelName(orderDTO.getModelName());
		od.setTotalPrice(orderDTO.getTotalPrice());
		od.setOrderAccessoryDetails(orderDTO.getAccessoriesSelected());
		od.setOrderColorDetails(orderDTO.getColorsSelected());
		orderDetailsRepository.save(od);
	}

	public OrderDTO getAllOrders() {
		OrderDetails od = orderDetailsRepository.getAllOrders();
		List<OrderColorDetails> ocd = orderColorDetailsRepository.findAll();
		List<OrderAccessoryDetails> oad = orderAccessoryDetailsRepository.findAll();
		OrderDTO sendData = new OrderDTO();		
		sendData.setUserId(od.getUserId());
		sendData.setSeriesId(od.getSeriesId());
		sendData.setSeriesName(od.getSeriesName());
		sendData.setModelId(od.getModelId());
		sendData.setModelName(od.getModelName());
		sendData.setTotalPrice(od.getTotalPrice());
		sendData.setAccessoriesSelected(od.getOrderAccessoryDetails());
		sendData.setColorsSelected(od.getOrderColorDetails());	
		return sendData;

	}
}
