package br.unipar.jsfaula.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unipar.jsfaula.dao.GenericDAO;
import br.unipar.jsfaula.domain.Candidato;

@ManagedBean(name="listagemCandidatoBean")
@ViewScoped
public class ListagemCandidatoBean {

	private List<Candidato> candidatos;

	public ListagemCandidatoBean() {
		pesquisar();
	}
	
	private void pesquisar() {
		GenericDAO<Candidato> dao = new GenericDAO<>();
		candidatos = dao.buscarTodos(Candidato.class);
	}
	
	public List<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(List<Candidato> candidatos) {
		this.candidatos = candidatos;
	}
	
}
