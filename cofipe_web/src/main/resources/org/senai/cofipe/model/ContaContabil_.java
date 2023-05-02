package org.senai.cofipe.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2023-04-26T17:46:40.495-0300")
@StaticMetamodel(ContaContabil.class)
public class ContaContabil_ {
	public static volatile SingularAttribute<ContaContabil, Integer> id;
	public static volatile SingularAttribute<ContaContabil, String> codigo;
	public static volatile SingularAttribute<ContaContabil, String> nome;
	public static volatile SingularAttribute<ContaContabil, String> descricao;
	public static volatile SetAttribute<ContaContabil, Lancamento> lancamentos;
}
