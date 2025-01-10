package com.devsuperior.dscommerce.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity
@Table(name = "tb_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String email;
	private String phone;
	
	// representa uma data (ano, mês e dia) sem informação de horário. 
	private LocalDate birthDate;
	private String password;
	
	/*
	 Relacionamento  um cliente (User) pode fazer vários pedidos(Order)
	 * */
	
	@OneToMany(mappedBy = "client")//esse client é mesmo nome do atributo do User na na classe Order
	private List<Order> orders = new ArrayList<>();//utilizado porque o user(Client) pode fazer vários pedidos(Order)
	
	
	//padrão construtor vazio
	public User() {
		
	}

	//Construtor
	public User(Long id, String name, String email, String phone, LocalDate birthDate, String password) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.birthDate = birthDate;
		this.password = password;
	}

	
	//Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public List<Order> getOrders() {
		return orders;
	}
	

}
