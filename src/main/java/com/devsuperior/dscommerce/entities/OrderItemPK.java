package com.devsuperior.dscommerce.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

//Criando classe composta com associação Order e Product onde será ligada para
//a classe OrderItem utilizado para muitos-para-muitos com classe de associação
//dessa forma essa classe vai fazer muitos-para-um para order e para product

//permitindo que você trabalhe com tipos de dados compostos e simplifique o esquema do seu banco de dados.
@Embeddable
public class OrderItemPK {
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	
	//fazendo o relacionamento com a classe Order
	private Order order;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	//fazendo o relacionamento com a classe Product
	private Product product;
	
	

	//criando construtor vazio por padrão
	public OrderItemPK() {
		
	}



	public Order getOrder() {
		return order;
	}



	public void setOrder(Order order) {
		this.order = order;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	@Override
	public int hashCode() {
		return Objects.hash(order, product);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItemPK other = (OrderItemPK) obj;
		return Objects.equals(order, other.order) && Objects.equals(product, other.product);
	}
	
	
	
	
}
