package com.food.delivery.entity;


import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="USER")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotBlank(message="name should not be blank")
	private int id;
	
	@Column(name = "FIRST_NAME", length = 225)
	@NotBlank(message="name should not be blank")
	private String firstname;

	@Column(name = "LAST_NAME", length = 225)
	@NotBlank(message="name should not be blank")
	private String lastname;

	@Column(name = "LOGIN")
	@NotBlank(message="name should not be blank")
	private String login;

	@Column(name = "PASSWORD", length = 225)
	@NotBlank(message="name should not be blank")
	private String password;
	
	@NotBlank(message="name should not be blank")
	private String confirmPassword;

	@Column(name = "ROLE_ID", length = 225)
	@NotBlank(message="name should not be blank")
	private long roleId;

	@Column(name = "EMAIL_ID", length = 225, unique = true)
	private String email;

	@Column(name = "GENDER", length = 225)
	@NotBlank(message="name should not be blank")
	private String gender;
	
//	@Column(name = "DOB")
//	@NotBlank(message="name should not be blank")
//	@Temporal(TemporalType.DATE)
//	private Date dob;
	
	@Column(name = "CONTACT_NO", length = 225)
	@NotBlank(message="name should not be blank")
	private String contact;
	
//	private List<Order> orders = new ArrayList<>()
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private Set<Cart> carts;
	
	public User() {
		super();
	}

	public User(int id,  String firstname,
			String lastname,
			String login,
			String password, 
			String confirmPassword,
			long roleId, 
			String email,
			String gender, 
			String contact, Set<Cart> carts) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.login = login;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.roleId = roleId;
		this.email = email;
		this.gender = gender;
		this.contact = contact;
		this.carts = carts;
	}
	
	
	
}
