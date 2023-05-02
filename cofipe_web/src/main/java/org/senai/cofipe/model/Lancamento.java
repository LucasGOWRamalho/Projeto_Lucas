package org.senai.cofipe.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.senai.cofipe.model.enums.FormaPagamento;
import org.senai.cofipe.model.enums.TipoLancamento;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lancamento")
	private Integer id;
	
	@Column(name = "data_lancamento", nullable = false)
	private LocalDate dataLancamento;
	
	@Column(name = "data_liquidacao")
	private LocalDate dataLiquidacao;
	
	@Column(name = "valor", nullable = false)
	private Double valor;
	
	@Enumerated(EnumType.STRING)
	private TipoLancamento tipoLancamento;
	
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "liquidado", nullable = false)
	private Boolean liquidado;
	
	@ManyToOne
	@JoinColumn(name = "id_conta_contabil", nullable = false)
	private ContaContabil contaContabil;
	
	@OneToOne(mappedBy = "lancamento")
	private FluxoCaixa fluxoCaixa;
	
	@Enumerated(EnumType.STRING)
	private FormaPagamento formaPagamento;
	
	public Lancamento(Integer id) {
		this.id = id;
	}
	
	public Lancamento() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataLancamento() {
		return dataLancamento;
	}

	public void setDataLancamento(LocalDate dataLancamento) {
		this.dataLancamento = dataLancamento;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public TipoLancamento getTipoLancamento() {
		return tipoLancamento;
	}

	public void setTipoLancamento(TipoLancamento tipoLancamento) {
		this.tipoLancamento = tipoLancamento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public LocalDate getDataLiquidacao() {
		return dataLiquidacao;
	}

	public void setDataLiquidacao(LocalDate dataLiquidacao) {
		this.dataLiquidacao = dataLiquidacao;
	}

	public Boolean getLiquidado() {
		return liquidado;
	}

	public void setLiquidado(Boolean liquidado) {
		this.liquidado = liquidado;
	}

	public ContaContabil getContaContabil() {
		return contaContabil;
	}

	public void setContaContabil(ContaContabil contaContabil) {
		this.contaContabil = contaContabil;
	}

	public FluxoCaixa getFluxoCaixa() {
		return fluxoCaixa;
	}

	public void setFluxoCaixa(FluxoCaixa fluxoCaixa) {
		this.fluxoCaixa = fluxoCaixa;
	}

	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}
	
}
