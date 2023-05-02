package org.senai.cofipe.dbload;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.senai.cofipe.model.ContaContabil;
import org.senai.cofipe.model.FluxoCaixa;
import org.senai.cofipe.model.Lancamento;
import org.senai.cofipe.model.enums.FormaPagamento;
import org.senai.cofipe.model.enums.TipoLancamento;
import org.senai.cofipe.service.ContaContabilService;
import org.senai.cofipe.service.FluxoCaixaService;
import org.senai.cofipe.service.LancamentoService;

public class DBLoad {

	public static void main(String[] args) {
		new DBLoad().load();
	}

	public void load() {
		LancamentoService lancamentoService = new LancamentoService();
		ContaContabilService contaService = new ContaContabilService();
		FluxoCaixaService fluxoService = new FluxoCaixaService();

		ContaContabil contaPersistida = contaService.persist(getContaContabil());

		for (Lancamento lcto : getLancamentos()) {
			lcto.setContaContabil(contaPersistida);
			Lancamento lctoPersistido = lancamentoService.persist(lcto);
			FluxoCaixa fluxoPersistido = getFluxoCaixa(lctoPersistido);
			fluxoService.persist(fluxoPersistido);
		}

	}

	private List<Lancamento> getLancamentos() {
		List<Lancamento> lctos = new ArrayList<>();
		int dia = 1;

		for (Despesa d : getDespesas()) {
			Lancamento lcto = new Lancamento();
			lcto.setDataLancamento(LocalDate.of(2023, 4, dia++));
			lcto.setTipoLancamento(TipoLancamento.D);
			lcto.setDescricao(d.nome);
			lcto.setDataLiquidacao(LocalDate.of(2023, 5, 10));
			lcto.setLiquidado(false);
			lcto.setValor(d.valor);
			lcto.setFormaPagamento(FormaPagamento.INTERNET_BANCKING);
			lctos.add(lcto);
		}

		return lctos;
	}

	class Despesa {
		String nome;
		Double valor;

		Despesa(String nome, Double valor) {
			this.nome = nome;
			this.valor = valor;
		}
	}

	private List<Despesa> getDespesas() {
		List<Despesa> despesas = new ArrayList<>();
		despesas.add(new Despesa("Lanche", 15.0));
		despesas.add(new Despesa("Energia elétrica", 85.0));
		despesas.add(new Despesa("Água e esgoto", 60.0));
		despesas.add(new Despesa("Aluguel", 850.0));
		despesas.add(new Despesa("Mercado", 112.0));
		despesas.add(new Despesa("Combustível", 150.0));
		despesas.add(new Despesa("Internet", 100.0));

		return despesas;
	}

	private FluxoCaixa getFluxoCaixa(Lancamento lcto) {
		FluxoCaixa fluxo = new FluxoCaixa();
		fluxo.setSaldoPrevisto(lcto.getValor());
		fluxo.setSaldoRealizado(lcto.getValor());
		fluxo.setLancamento(lcto);
		return fluxo;
	}

	private ContaContabil getContaContabil() {
		ContaContabil conta = new ContaContabil();
		conta.setCodigo("CC-M01");
		conta.setDescricao("Despesa mensal");
		conta.setNome("Mensal");

		return conta;
	}
}
