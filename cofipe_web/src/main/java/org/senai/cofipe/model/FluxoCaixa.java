package org.senai.cofipe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fluxo_caixa")
public class FluxoCaixa implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_fluxo_caixa")
	private Integer id;
	
	@Column(name = "saldo_previsto", nullable = false)
	private Double saldoPrevisto;
	
	@Column(name = "saldo_realizado", nullable = false)
	private Double saldoRealizado;
	
	@OneToOne
	@JoinColumn(name = "id_lancamento", nullable = false)
	private Lancamento lancamento;
	
	public FluxoCaixa(Integer id) {
		this.id = id;
	}
	
	public FluxoCaixa() {}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getSaldoPrevisto() {
		return saldoPrevisto;
	}
	public void setSaldoPrevisto(Double saldoPrevisto) {
		this.saldoPrevisto = saldoPrevisto;
	}
	public Double getSaldoRealizado() {
		return saldoRealizado;
	}
	public void setSaldoRealizado(Double saldoRealizado) {
		this.saldoRealizado = saldoRealizado;
	}
	public Lancamento getLancamento() {
		return lancamento;
	}
	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}
	
}
