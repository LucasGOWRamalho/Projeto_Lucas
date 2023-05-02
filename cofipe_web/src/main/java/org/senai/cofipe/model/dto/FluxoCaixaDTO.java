package org.senai.cofipe.model.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import org.senai.cofipe.model.Lancamento;
/**
 * Classe DTO (Data Transfer Object) usada para gerar o relatório de fluxo de caixa
 * @author Rudimar Schmitz
 * @since 2023-04-14
 * @version 1.0
 *
 */
public class FluxoCaixaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Set<Lancamento> lancamentos;
	private LocalDate dataInicial;
	private LocalDate dataFinal;
	private Double saldoInicial;
	private Double saldoFinal;
	
	public Set<Lancamento> getLancamentos() {
		return lancamentos;
	}
	public void setLancamentos(Set<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
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
	public Double getSaldoInicial() {
		return saldoInicial;
	}
	public void setSaldoInicial(Double saldoInicial) {
		this.saldoInicial = saldoInicial;
	}
	public Double getSaldoFinal() {
		return saldoFinal;
	}
	public void setSaldoFinal(Double saldoFinal) {
		this.saldoFinal = saldoFinal;
	}
	
}
