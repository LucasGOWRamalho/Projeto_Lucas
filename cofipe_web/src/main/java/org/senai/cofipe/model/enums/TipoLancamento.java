package org.senai.cofipe.model.enums;

/**
 * Enum com os tipos de lançamento possíveis:
 * D: débito; C: crédito; M: movimentação
 * @author Rudimar Schmitz
 * @since 2023-04-08
 * @version 1.0
 *
 */
public enum TipoLancamento {
	D("Débito"), C("Crédito"), M("Movimentação");
	
	private final String value;
	
	private TipoLancamento(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}



