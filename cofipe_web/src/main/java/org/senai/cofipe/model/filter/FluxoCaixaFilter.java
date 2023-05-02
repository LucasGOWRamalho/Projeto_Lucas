package org.senai.cofipe.model.filter;

import java.io.Serializable;
import java.time.LocalDate;

import org.senai.cofipe.model.enums.TipoLancamento;

/**
 * Classe usada para armazenar os valores do filtro para a pesquisa realizada para montar o fluxo de caixa
 * @author Rudimar Schmitz
 * @since 2023-04-14
 * @version 1.0
 *
 */
public class FluxoCaixaFilter implements Serializable {
	private static final long serialVersionUID = 1L;
	private LocalDate dataInicial;
	private LocalDate fataFinal;
	private TipoLancamento tipoLancamento;
	
	public LocalDate getDataInicial() {
		return dataInicial;
	}
	public void setDataInicial(LocalDate dataInicial) {
		this.dataInicial = dataInicial;
	}
	public LocalDate getFataFinal() {
		return fataFinal;
	}
	public void setFataFinal(LocalDate fataFinal) {
		this.fataFinal = fataFinal;
	}
	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}
	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}
	
}
