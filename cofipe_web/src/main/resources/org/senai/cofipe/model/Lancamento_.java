package org.senai.cofipe.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.senai.cofipe.model.enums.FormaPagamento;
import org.senai.cofipe.model.enums.TipoLancamento;

@Generated(value="Dali", date="2023-04-26T17:46:40.529-0300")
@StaticMetamodel(Lancamento.class)
public class Lancamento_ {
	public static volatile SingularAttribute<Lancamento, Integer> id;
	public static volatile SingularAttribute<Lancamento, LocalDate> dataLancamento;
	public static volatile SingularAttribute<Lancamento, LocalDate> dataLiquidacao;
	public static volatile SingularAttribute<Lancamento, Double> valor;
	public static volatile SingularAttribute<Lancamento, TipoLancamento> tipoLancamento;
	public static volatile SingularAttribute<Lancamento, String> descricao;
	public static volatile SingularAttribute<Lancamento, Boolean> liquidado;
	public static volatile SingularAttribute<Lancamento, ContaContabil> contaContabil;
	public static volatile SingularAttribute<Lancamento, FluxoCaixa> fluxoCaixa;
	public static volatile SingularAttribute<Lancamento, FormaPagamento> formaPagamento;
}
