package com.devsuperior.dscommerce.entities;

import java.time.Instant;

import com.devsuperior.dscommerce.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")

public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;
	
	@Enumerated(EnumType.STRING) // Anotação para persistir o enum como string
	private OrderStatus status;//enum vem da classe OrderStatus
	
	//relacionamento 1 usuário pode ter vário * pedidos
	// ou seja como estamos dentro da classe Order(Pedido) pode ser feito VÁRIO PEDIDOS * UM CLIENTE (USER)
	
	@ManyToOne
	@JoinColumn(name = "client_id")//esse cara vai fica como uma chave estrangeira referencia da tabela User(client)
	private User client;//ralacionando com a classe User com atributo client
	
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;
	
	
	

	public Payment getPayment() {
		return payment;
	}


	public void setPayment(Payment payment) {
		this.payment = payment;
	}


	//construtor vazio
	public Order() {
		
	}
	
	
	//construtor
	public Order(Long id, Instant moment, OrderStatus status, User client, Payment payment) {
	
		this.id = id;
		this.moment = moment;
		this.status = status;
		this.client = client;
		this.payment = payment;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Instant getMoment() {
		return moment;
	}


	public void setMoment(Instant moment) {
		this.moment = moment;
	}


	public OrderStatus getStatus() {
		return status;
	}


	public void setStatus(OrderStatus status) {
		this.status = status;
	}


	public User getClient() {
		return client;
	}


	public void setClient(User client) {
		this.client = client;
	}
	
	
	
}
