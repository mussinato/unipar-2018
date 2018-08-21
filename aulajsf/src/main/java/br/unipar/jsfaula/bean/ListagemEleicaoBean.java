package br.unipar.jsfaula.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unipar.jsfaula.dao.GenericDAO;
import br.unipar.jsfaula.domain.Eleicao;

@ManagedBean(name="listagemEleicaoBean")
@ViewScoped
public class ListagemEleicaoBean {

	private List<Eleicao> eleicoes;

	public ListagemEleicaoBean() {
		pesquisar();
	}
	
	private void pesquisar() {
		GenericDAO<Eleicao> dao = new GenericDAO<>();
		eleicoes = dao.buscarTodos(Eleicao.class);
	}
	
	public List<Eleicao> getEleicoes() {
		return eleicoes;
	}

	public void setEleicoes(List<Eleicao> eleicoes) {
		this.eleicoes = eleicoes;
	}
	
}
