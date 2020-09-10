package com.cts.OrderService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_accessory_details")
public class OrderAccessoryDetails {
	@Id
	@GeneratedValue
	@Column(name = "order_accessory_id")
	private long orderAccessoryId;
	@Column(name = "accessory_id")
	private long accessoryId;
	@Column(name = "accessory_name")
	private String accessoryName;

	public OrderAccessoryDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderAccessoryId() {
		return orderAccessoryId;
	}

	public void setOrderAccessoryId(long orderAccessoryId) {
		this.orderAccessoryId = orderAccessoryId;
	}

	public long getAccessoryId() {
		return accessoryId;
	}

	public void setAccessoryId(long accessoryId) {
		this.accessoryId = accessoryId;
	}

	public String getAccessoryName() {
		return accessoryName;
	}

	public void setAccessoryName(String accessoryName) {
		this.accessoryName = accessoryName;
	}

	public OrderAccessoryDetails(long orderAccessoryId, long accessoryId, String accessoryName) {
		super();
		this.orderAccessoryId = orderAccessoryId;
		this.accessoryId = accessoryId;
		this.accessoryName = accessoryName;
	}

}
