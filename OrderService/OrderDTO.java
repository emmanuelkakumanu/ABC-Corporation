package com.cts.OrderService.DTO;

import java.util.List;

import com.cts.OrderService.model.OrderAccessoryDetails;
import com.cts.OrderService.model.OrderColorDetails;

public class OrderDTO {

	private long orderId;
	private long seriesId;
	private long modelId;
	//private long totalPrice;
	private List<OrderColorDetails> orderColorDetails;
	private List<OrderAccessoryDetails> orderAccessoryDetails;

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getSeriesId() {
		return seriesId;
	}

	public void setSeriesId(long seriesId) {
		this.seriesId = seriesId;
	}

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

//	public long getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setTotalPrice(long totalPrice) {
//		this.totalPrice = totalPrice;
//	}

	public List<OrderColorDetails> getOrderColorDetails() {
		return orderColorDetails;
	}

	public void setOrderColorDetails(List<OrderColorDetails> orderColorDetails) {
		this.orderColorDetails = orderColorDetails;
	}

	public List<OrderAccessoryDetails> getOrderAccessoryDetails() {
		return orderAccessoryDetails;
	}

	public void setOrderAccessoryDetails(List<OrderAccessoryDetails> orderAccessoryDetails) {
		this.orderAccessoryDetails = orderAccessoryDetails;
	}

	public OrderDTO(long orderId, long seriesId, long modelId, long totalPrice,
			List<OrderColorDetails> orderColorDetails, List<OrderAccessoryDetails> orderAccessoryDetails) {
		super();
		this.orderId = orderId;
		this.seriesId = seriesId;
		this.modelId = modelId;
		//this.totalPrice = totalPrice;
		this.orderColorDetails = orderColorDetails;
		this.orderAccessoryDetails = orderAccessoryDetails;
	}

}
