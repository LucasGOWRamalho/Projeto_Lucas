package org.senai.cofipe.view.filter;

import java.io.Serializable;
import java.time.LocalDate;

public class LancamentoFilter implements Serializable {
	private static final long serialVersionUID = 1L;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	
}
