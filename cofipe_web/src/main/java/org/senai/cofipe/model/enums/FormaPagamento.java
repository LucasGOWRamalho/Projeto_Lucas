package org.senai.cofipe.model.enums;

public enum FormaPagamento {
	DINHEIRO("Dinheiro"),
	PIX("PIX"),
	CARTAO_DEBITO("Cartão de débito"),
	INTERNET_BANCKING("Internet banking"),
	OUTRO("Outro");
	
	private String value;
	
	private FormaPagamento(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
	
}
