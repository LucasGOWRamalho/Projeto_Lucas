package org.senai.cofipe.view;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.senai.cofipe.model.Lancamento;
import org.senai.cofipe.model.enums.FormaPagamento;
import org.senai.cofipe.model.enums.TipoLancamento;
import org.senai.cofipe.model.exception.DataException;
import org.senai.cofipe.model.validacao.LancamentoValidacao;
import org.senai.cofipe.service.LancamentoService;
import org.senai.cofipe.view.filter.LancamentoFilter;

@Named(value = "lctoBean")
@SessionScoped
public class LancamentoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private LancamentoService service;
	private List<Lancamento> lancamentos;
	private Lancamento lancamento;
	private Lancamento lctoSelecionado;
	private List<FormaPagamento> formasPagamento;
	private List<TipoLancamento> tiposLancamento;
	private LancamentoFilter filter;
	/** Representa a quantidade de dias a ser considerada na carga inicial da lista.
	 *  O resultado será igual a hoje - dias. */
	private final long dias = 31;

	public LancamentoBean() {
		this.service = new LancamentoService();
		this.lancamentos = service.getByPeriodo(dias);
	}
	
	@PostConstruct
	public void init() {
		this.formasPagamento = Arrays.asList(FormaPagamento.values());
		this.tiposLancamento = Arrays.asList(TipoLancamento.values());
		this.filter = new LancamentoFilter();
	}
	
	public void pesquisaPorDatas() {
		try {
			if (filter.getDataFinal() == null || filter.getDataFinal().toString().isEmpty()) {
				filter.setDataFinal(LocalDate.now());
			}
			if (new LancamentoValidacao().isDataFilterOK(filter)) {
				this.lancamentos = service.getByDates(filter);
			}
		} catch (DataException ex) {
			messages("ERRO DE VALIDAÇÃO", ex.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	public void onRowEdit(RowEditEvent<Lancamento> event) {
		this.update();
		messages("ATUALIZADO", "Atualização realizada.", FacesMessage.SEVERITY_INFO);
	}

	public void onRowCancel(RowEditEvent<Lancamento> event) {
		messages("CANCELADO", "A edição foi cancelada.", FacesMessage.SEVERITY_INFO);
	}
	
	public void messages(String summary, String message, Severity severityInfo) {
        FacesContext.getCurrentInstance().
        	addMessage(null, new FacesMessage(severityInfo, summary, message));
	}

	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}

	public void persist() {
		service.persist(lancamento);
	}
	
	public void update() {
		this.service.update(this.lctoSelecionado);
	}

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}

	public Lancamento getLctoSelecionado() {
		return lctoSelecionado;
	}

	public void setLctoSelecionado(Lancamento lctoSelecionado) {
		this.lctoSelecionado = lctoSelecionado;
	}

	public List<FormaPagamento> getFormasPagamento() {
		return formasPagamento;
	}

	public void setFormasPagamento(List<FormaPagamento> formasPagamento) {
		this.formasPagamento = formasPagamento;
	}

	public List<TipoLancamento> getTiposLancamento() {
		return tiposLancamento;
	}

	public void setTiposLancamento(List<TipoLancamento> tiposLancamento) {
		this.tiposLancamento = tiposLancamento;
	}

	public LancamentoFilter getFilter() {
		return filter;
	}

	public void setFilter(LancamentoFilter filter) {
		this.filter = filter;
	}

}
