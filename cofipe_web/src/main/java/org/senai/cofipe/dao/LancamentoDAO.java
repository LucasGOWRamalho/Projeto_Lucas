package org.senai.cofipe.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.TypedQuery;

import org.senai.cofipe.model.Lancamento;
import org.senai.cofipe.view.filter.LancamentoFilter;

public class LancamentoDAO extends DAO<Lancamento> {

	public LancamentoDAO() {
		super(Lancamento.class);
	}

	public List<Lancamento> getByDates(LancamentoFilter filter) {
		String sql = "SELECT l FROM Lancamento l WHERE l.dataLancamento BETWEEN :dtInicial AND :dtFinal";
		
		TypedQuery<Lancamento> query = super.getDAOUtil().getEM().createQuery(sql, Lancamento.class);
		query.setParameter("dtInicial", filter.getDataInicial());
		query.setParameter("dtFinal", filter.getDataFinal());
		
		return query.getResultList();
	}

	public List<Lancamento> getByPeriodo(long dias) {
		LocalDate hoje = LocalDate.now();
		LocalDate dtInicial = hoje.minusDays(dias);
		
		String sql = "SELECT l FROM Lancamento l WHERE l.dataLancamento BETWEEN :dtInicial AND :dtFinal";
		
		TypedQuery<Lancamento> query = super.getDAOUtil().getEM().createQuery(sql, Lancamento.class);
		query.setParameter("dtInicial", dtInicial);
		query.setParameter("dtFinal", hoje);
		
		return query.getResultList();
	}

}
