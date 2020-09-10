package com.cts.OrderService.DTO;

import java.util.List;

import com.cts.OrderService.model.OrderAccessoryDetails;
import com.cts.OrderService.model.OrderColorDetails;

public class OrderDTO {

	private long userId;
	private long seriesId;
	private String seriesName;
	private long modelId;
	private String modelName;
	private long totalPrice;
	private List<OrderColorDetails> colorsSelected;
	private List<OrderAccessoryDetails> accessoriesSelected;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public OrderDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<OrderColorDetails> getColorsSelected() {
		return colorsSelected;
	}

	public void setColorsSelected(List<OrderColorDetails> colorsSelected) {
		this.colorsSelected = colorsSelected;
	}

	public List<OrderAccessoryDetails> getAccessoriesSelected() {
		return accessoriesSelected;
	}

	public void setAccessoriesSelected(List<OrderAccessoryDetails> accessoriesSelected) {
		this.accessoriesSelected = accessoriesSelected;
	}

	public OrderDTO(long userId, long seriesId, String seriesName, long modelId, String modelName, long totalPrice,
			List<OrderColorDetails> colorsSelected, List<OrderAccessoryDetails> accessoriesSelected) {
		super();
		this.userId = userId;
		this.seriesId = seriesId;
		this.seriesName = seriesName;
		this.modelId = modelId;
		this.modelName = modelName;
		this.totalPrice = totalPrice;
		this.colorsSelected = colorsSelected;
		this.accessoriesSelected = accessoriesSelected;
	}

}
