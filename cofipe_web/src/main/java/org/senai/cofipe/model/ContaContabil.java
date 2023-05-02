package org.senai.cofipe.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

@Entity
@Table(name = "conta_contabil")
public class ContaContabil implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_conta_contabil")
	private Integer id;
	
	@Column(name = "codigo", nullable = false)
	private String codigo;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "descricao")
	private String descricao;
	
	@OneToMany(mappedBy = "contaContabil")
	@OrderBy("dataLancamento asc")
	private Set<Lancamento> lancamentos;
	
	public ContaContabil(Integer id) {
		this.id = id;
	}
	
	public ContaContabil() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Set<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(Set<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}
	
}
