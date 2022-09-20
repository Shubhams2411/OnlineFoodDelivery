package com.food.delivery.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pId;
	@Column(name = "NAME", length = 225)
	private String name;
	@Column(name = "DESCRIPTION", length = 225)
	private String description;
	@Column(name = "PRICE", length = 225)
	private String price;
	@Column(name = "IMAGE", columnDefinition = "LONGBLOB")
	private byte[] image;

	@Transient
	private long categoryId;

	@ManyToOne
	@JoinColumn(name = "CATEGORY", nullable = false)
	private Category category;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Cart> carts;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private Set<Order> orders;

//	@Override
//	public String getKey() {
//		return String.valueOf(id);
//	}
//
//	@Override
//	public String getValue() {
//		return name;
//	}

}
