package com.devsuperior.dscommerce.entities;

import java.time.Instant;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_payment")//tabela pagamento

public class Payment {//Classe pagamento
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//id com auto-incremento
	private Long id;
	
	/*
	Instant é uma classe da API java.time do Java que representa um
	 ponto específico na linha do tempo,
	 independente de fuso horário. 
	É ideal para registrar momentos únicos e 
	para trocar informações de tempo entre sistemas. 
	*/
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant moment;

	//1 payment(Um (1) pagamneto tem 1 Order(Pedido) )
	@OneToOne
	
	@MapsId //  É útil em relacionamentos com chave primária compartilhada ou composta, 
	//e ajuda a manter a consistência dos dados
	
	private Order order;//relacionamento classe Order(Pedido)
	
	//construtor sem atributos vazio
	public Payment() {
		
	}

	public Payment(Long id, Instant moment, Order order) {
		
		this.id = id;
		this.moment = moment;
		this.order = order;
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

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
	
	
}
