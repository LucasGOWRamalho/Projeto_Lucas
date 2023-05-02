package org.senai.cofipe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-04-26T17:46:40.528-0300")
@StaticMetamodel(FluxoCaixa.class)
public class FluxoCaixa_ {
	public static volatile SingularAttribute<FluxoCaixa, Integer> id;
	public static volatile SingularAttribute<FluxoCaixa, Double> saldoPrevisto;
	public static volatile SingularAttribute<FluxoCaixa, Double> saldoRealizado;
	public static volatile SingularAttribute<FluxoCaixa, Lancamento> lancamento;
}
