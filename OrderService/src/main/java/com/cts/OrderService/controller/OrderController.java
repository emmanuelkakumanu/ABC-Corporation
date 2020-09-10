package com.cts.OrderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.OrderService.DTO.OrderDTO;
import com.cts.OrderService.model.OrderDetails;
import com.cts.OrderService.service.OrderService;

@RestController

public class OrderController {

	@Autowired
	private OrderService orderService;

	@PostMapping("/placeorder")
	public void placeOrder(@RequestBody OrderDTO orderDTO) {
		orderService.placeOrder(orderDTO);

	}

	@GetMapping("/allorders")
	public OrderDTO getAllOrders() {
		return orderService.getAllOrders();

	}
}
