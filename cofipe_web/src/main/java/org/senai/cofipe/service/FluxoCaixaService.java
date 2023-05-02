package org.senai.cofipe.service;

import org.senai.cofipe.model.FluxoCaixa;
import org.senai.cofipe.model.dto.FluxoCaixaDTO;
import org.senai.cofipe.model.filter.FluxoCaixaFilter;

public class FluxoCaixaService extends Service<FluxoCaixa> {
	
	public FluxoCaixaService() {
		super(FluxoCaixa.class);
	}

	public FluxoCaixaDTO gerarFluxoDeCaixa(FluxoCaixaFilter filter) {
		FluxoCaixaDTO dto = new FluxoCaixaDTO();
		// a data final tem que ser a primeira data disponível na base de dados de acordo com a pesquisa.
		// Esta data não é, necessariamente, igual à do filtro uma vez que talvez não existam lançamentos
		// na data inicial informada no filtro. O mesmo vale para a data final.
		dto.setDataInicial(null);
		dto.setDataFinal(null);
		dto.setSaldoInicial(null);
		// saldo calculado até a dataFinal do fluxo de caixa
		dto.setSaldoFinal(null);
		return null;
	}
	
}
