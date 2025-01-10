package com.devsuperior.dscommerce.enums;

public enum OrderStatus {
	
	  WAITING_PAYMENT("Aguardando Pagamento"),
	    PAID("Pago"),
	    SHIPPED("Enviado"),
	    DELIVERED("Entregue"),
	    CANCELED("Cancelado");

	private String descricao;
	
		OrderStatus(String descricao) {
			this.descricao = descricao;
		}
	public String getDescricao() {
		return descricao;
	}
		
	
	
}
