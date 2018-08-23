package br.unipar.jsfaula.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="eleicao_candidato")
public class EleicaoCandidato {
	
	@Id
	@GeneratedValue
	private Long codigo;
	
	@ManyToOne
	private Eleicao eleicao;
	
	@ManyToOne
	private Candidato candidato;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public Eleicao getEleicao() {
		return eleicao;
	}

	public void setEleicao(Eleicao eleicao) {
		this.eleicao = eleicao;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
}
