package com.food.delivery.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "CATEGORY")
@Setter
@Getter
public class Category  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "NAME", length = 225)
	private String name;
	@Column(name = "DESCRIPTION", length = 225)
	private String description;
	@Column(name = "IMAGES", columnDefinition = "LONGBLOB")
	private byte[] images;

	@OneToMany(cascade = CascadeType.ALL,mappedBy = "category")
	private Set<Category> category;
	
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
