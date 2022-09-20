package com.food.delivery.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CART")
@Getter
@Setter
public class Cart {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int cid;
	@Column(name = "QUANTITY", length = 225)
	private String quantity;
	@Column(name = "PRICE", length = 225)
	private String price;
	@Column(name = "TOTAL_PRICE", length = 225)
	private String totalPrice;

	@ManyToOne
	@JoinColumn(name = "USER", nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(name = "PRODUCT", nullable = false)
	private Product product;

//	@Override
//	public String getKey() {
//		return null;
//	}
//
//	@Override
//	public String getValue() {
//		return null;
//	}
}
