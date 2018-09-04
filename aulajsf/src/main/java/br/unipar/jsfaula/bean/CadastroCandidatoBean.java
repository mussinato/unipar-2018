package br.unipar.jsfaula.bean;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.unipar.jsfaula.dao.GenericDAO;
import br.unipar.jsfaula.domain.Candidato;

@ManagedBean(name="cadastroCandidatoBean")
@SessionScoped
public class CadastroCandidatoBean {

	private Candidato candidato = new Candidato();
	private String antes = null;
	
	public CadastroCandidatoBean() {
		System.out.println("Executando construtor CadastroCandidatoBean");
		Map<String, String> params = FacesContext.getCurrentInstance()
											.getExternalContext()
											.getRequestParameterMap();
		String codigo = params.get("codcandidato");
		
		if (codigo != null && !codigo.equals("")) {
			GenericDAO<Candidato> dao = new GenericDAO<>();
			candidato = dao.buscarPorCodigo(Candidato.class, Long.parseLong(codigo));
		}
	}
	
	public void salvar() {
		showMessage("Antes", antes, FacesMessage.SEVERITY_INFO);
		antes = ""+candidato.getCodigo() + " - " + candidato.getNome();
		showMessage("Depois", antes, FacesMessage.SEVERITY_INFO);
//		GenericDAO<Candidato> dao = new GenericDAO<>();
//		try {
//			dao.salvar(candidato);
//			candidato = new Candidato();
//	        showMessage("Sucesso", "Candidato cadastrado.", FacesMessage.SEVERITY_INFO);
//		} catch (Exception e) {
//			e.printStackTrace();
//	        showMessage("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
//		}
	}
	
	private void showMessage(String titulo, String mensagem, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, 
        		new FacesMessage(severity,titulo,mensagem));
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}	
	
}
