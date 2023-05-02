package org.senai.cofipe.model.validacao;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.senai.cofipe.model.exception.DataException;
import org.senai.cofipe.view.filter.LancamentoFilter;

public class LancamentoValidacao {
	/** Quantidade máxima de dias na pesquisa */
	private static final Integer MAX_DIAS = 31;

	public Boolean isDataFilterOK(LancamentoFilter filter) throws DataException {
		LocalDate dtInicial = filter.getDataInicial();
		LocalDate dtFinal = filter.getDataFinal();
		
		if (dtInicial == null || dtInicial.toString().isEmpty()) {
			throw new DataException("A data inicial não pode estar vazia.");
		}
		if (dtInicial.isAfter(dtFinal)) {
			throw new DataException("A data inicial não pode ser posterior à data final.");
		}
		if (ChronoUnit.DAYS.between(dtInicial, dtFinal) > MAX_DIAS) {
			throw new DataException("A quantidade de dias da pesquisa não pode ser maior do que 31.");
		}

		return true;
	}
}
