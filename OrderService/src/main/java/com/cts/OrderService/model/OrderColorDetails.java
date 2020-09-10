package com.cts.OrderService.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "order_color_details")
public class OrderColorDetails implements Serializable {
	@Id
	@GeneratedValue
	@Column(name = "order_color_id")
	private long orderColorId;
	@Column(name = "color_id")
	private long colorId;
	@Column(name = "color_name")
	private String colorName;
	//@Column(name = "color_quantity")
	//private long colorQuantity;

	public OrderColorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getOrderColorId() {
		return orderColorId;
	}

	public void setOrderColorId(long orderColorId) {
		this.orderColorId = orderColorId;
	}

	public long getColorId() {
		return colorId;
	}

	public void setColorId(long colorId) {
		this.colorId = colorId;
	}

	public String getColorName() {
		return colorName;
	}

	public void setColorName(String colorName) {
		this.colorName = colorName;
	}

	@Override
	public String toString() {
		return "OrderColorDetails [orderColorId=" + orderColorId + ", colorId=" + colorId + ", colorName=" + colorName
				+ "]";
	}

	public OrderColorDetails(long orderColorId, long colorId, String colorName) {
		super();
		this.orderColorId = orderColorId;
		this.colorId = colorId;
		this.colorName = colorName;
	}

	
	

}
