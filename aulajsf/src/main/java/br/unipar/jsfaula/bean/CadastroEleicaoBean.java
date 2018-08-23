package br.unipar.jsfaula.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.TransferEvent;
import org.primefaces.model.DualListModel;

import br.unipar.jsfaula.dao.CandidatoDAO;
import br.unipar.jsfaula.dao.GenericDAO;
import br.unipar.jsfaula.domain.Candidato;
import br.unipar.jsfaula.domain.Eleicao;
import br.unipar.jsfaula.domain.EleicaoCandidato;

@ManagedBean(name="cadastroEleicaoBean")
@ViewScoped
public class CadastroEleicaoBean {

	private Eleicao eleicao = new Eleicao();
	private DualListModel<Candidato> candidatos;
	private DualListModel<String> cargos;
	
	public CadastroEleicaoBean() {
		Map<String, String> params = FacesContext.getCurrentInstance()
											.getExternalContext()
											.getRequestParameterMap();
		String codigo = params.get("codeleicao");
		
		if (codigo != null && !codigo.equals("")) {
			GenericDAO<Eleicao> dao = new GenericDAO<>();
			eleicao = dao.buscarPorCodigo(Eleicao.class, Long.parseLong(codigo));
			
			CandidatoDAO daoCandidato = new CandidatoDAO();
			List<Candidato> source = daoCandidato.buscarTodos(Candidato.class);
			List<Candidato> target = daoCandidato.buscarPorEleicao(eleicao);
			source.removeAll(target);
			candidatos = new DualListModel<Candidato>(source, target);
		} else {
			carregaTodosCandidatos(null);
		}
		carregaTodosCargos();
	}
	
	public void salvar() {
		GenericDAO<Eleicao> dao = new GenericDAO<>();
		try {
			eleicao = dao.salvar(eleicao);
			
			GenericDAO<EleicaoCandidato> daoEC = new GenericDAO<>();
			for (Candidato c : candidatos.getTarget()) {
				EleicaoCandidato candidatoNaEleicao = new EleicaoCandidato();
	        	candidatoNaEleicao.setCandidato(c);
	        	candidatoNaEleicao.setEleicao(eleicao);
	        	daoEC.salvar(candidatoNaEleicao);
			}
			
			eleicao = new Eleicao();
			carregaTodosCandidatos(null);
			carregaTodosCargos();
	        showMessage("Sucesso", "Eleição cadastrada.", FacesMessage.SEVERITY_INFO);
		} catch (Exception e) {
			e.printStackTrace();
	        showMessage("Erro", e.getMessage(), FacesMessage.SEVERITY_ERROR);
		}
	}

	private void carregaTodosCargos() {
		List<String> source = new ArrayList<>();
		source.add("Deputado Federal");
		source.add("Deputado Estadual");
		source.add("Senador");
		source.add("Governador");
		source.add("Presidente");
		source.add("Prefeito");
		source.add("Vereador");
		
		List<String> target = new ArrayList<>();
		cargos = new DualListModel<String>(source, target);
	}
	
	private void carregaTodosCandidatos(List<String> cargos) {
		List<Candidato> source = null;
		List<Candidato> target = new ArrayList<>();
		if (cargos != null && cargos.size() > 0) {
			CandidatoDAO dao = new CandidatoDAO();
			source = dao.buscarPorCargo(cargos);
		} else {
			source = new ArrayList<>();
		}		
		candidatos = new DualListModel<Candidato>(source, target);
	}
	
	private void showMessage(String titulo, String mensagem, Severity severity) {
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, 
        		new FacesMessage(severity,titulo,mensagem));
	}
	
	public void onTransfer(TransferEvent event) {
   		carregaTodosCandidatos(cargos.getTarget());
    } 

	public Eleicao getEleicao() {
		return eleicao;
	}

	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}

	public DualListModel<Candidato> getCandidatos() {
		return candidatos;
	}

	public void setCandidatos(DualListModel<Candidato> candidatos) {
		this.candidatos = candidatos;
	}

	public DualListModel<String> getCargos() {
		return cargos;
	}

	public void setCargos(DualListModel<String> cargos) {
		this.cargos = cargos;
	}
	
	
	
}
