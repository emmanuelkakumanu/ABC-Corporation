package com.cts.OrderService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")
public class OrderDetails implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	private long orderId;
	@Column(name = "series_id")
	private long seriesId;
	@Column(name = "series_name")
	private String seriesName;
	@Column(name = "model_id")
	private long modelId;
	@Column(name = "model_name")
	private String modelName;
	@Column(name = "total_price")
	private long totalPrice;
	@Column(name = "user_id")
	private long userId;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_order_id", referencedColumnName = "order_id")
	private List<OrderAccessoryDetails> orderAccessoryDetails;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_order_id", referencedColumnName = "order_id")
	private List<OrderColorDetails> orderColorDetails;

	public OrderDetails() {
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

	public String getSeriesName() {
		return seriesName;
	}

	public void setSeriesName(String seriesName) {
		this.seriesName = seriesName;
	}

	public long getModelId() {
		return modelId;
	}

	public void setModelId(long modelId) {
		this.modelId = modelId;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public List<OrderAccessoryDetails> getOrderAccessoryDetails() {
		return orderAccessoryDetails;
	}

	public void setOrderAccessoryDetails(List<OrderAccessoryDetails> orderAccessoryDetails) {
		this.orderAccessoryDetails = orderAccessoryDetails;
	}

	public List<OrderColorDetails> getOrderColorDetails() {
		return orderColorDetails;
	}

	public void setOrderColorDetails(List<OrderColorDetails> orderColorDetails) {
		this.orderColorDetails = orderColorDetails;
	}

	public OrderDetails(long orderId, long seriesId, String seriesName, long modelId, String modelName, long totalPrice,
			long userId, List<OrderAccessoryDetails> orderAccessoryDetails, List<OrderColorDetails> orderColorDetails) {
		super();
		this.orderId = orderId;
		this.seriesId = seriesId;
		this.seriesName = seriesName;
		this.modelId = modelId;
		this.modelName = modelName;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.orderAccessoryDetails = orderAccessoryDetails;
		this.orderColorDetails = orderColorDetails;
	}

	@Override
	public String toString() {
		return "OrderDetails [orderId=" + orderId + ", seriesId=" + seriesId + ", seriesName=" + seriesName
				+ ", modelId=" + modelId + ", modelName=" + modelName + ", totalPrice=" + totalPrice + ", userId="
				+ userId + ", orderAccessoryDetails=" + orderAccessoryDetails + ", orderColorDetails="
				+ orderColorDetails + "]";
	}

}
