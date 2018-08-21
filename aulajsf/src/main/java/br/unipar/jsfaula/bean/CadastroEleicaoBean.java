package br.unipar.jsfaula.bean;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.unipar.jsfaula.dao.GenericDAO;
import br.unipar.jsfaula.domain.Eleicao;

@ManagedBean(name="cadastroEleicaoBean")
@ViewScoped
public class CadastroEleicaoBean {

	private Eleicao eleicao = new Eleicao();
	
	public CadastroEleicaoBean() {
		Map<String, String> params = FacesContext.getCurrentInstance()
											.getExternalContext()
											.getRequestParameterMap();
		String codigo = params.get("codeleicao");
		
		if (codigo != null && !codigo.equals("")) {
			GenericDAO<Eleicao> dao = new GenericDAO<>();
			eleicao = dao.buscarPorCodigo(Eleicao.class, Long.parseLong(codigo));
		}
	}
	
	public void salvar() {
		GenericDAO<Eleicao> dao = new GenericDAO<>();
		try {
			dao.salvar(eleicao);
			eleicao = new Eleicao();
	        showMessage("Sucesso", "Eleição cadastrada.", FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			e.printStackTrace();
	        showMessage("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}
	
	private void showMessage(String titulo, String mensagem, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, 
        		new FacesMessage(severity,titulo,mensagem));
	}

	public Eleicao getEleicao() {
		return eleicao;
	}

	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}

	
}
