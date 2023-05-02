package org.senai.cofipe.service;

import java.util.List;

import org.senai.cofipe.dao.LancamentoDAO;
import org.senai.cofipe.model.Lancamento;
import org.senai.cofipe.view.filter.LancamentoFilter;

public class LancamentoService extends Service<Lancamento>{
	private LancamentoDAO dao;

	public LancamentoService() {
		super(Lancamento.class);
		this.dao = new LancamentoDAO();
	}

	public List<Lancamento> getByDates(LancamentoFilter filter) {
		return dao.getByDates(filter);
	}
	
	public List<Lancamento> getByPeriodo(long dias) {
		return dao.getByPeriodo(dias);
	}

}
