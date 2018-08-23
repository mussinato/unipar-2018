package br.unipar.jsfaula.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import br.unipar.jsfaula.domain.Candidato;
import br.unipar.jsfaula.domain.Eleicao;
import br.unipar.jsfaula.domain.EleicaoCandidato;

public class CandidatoDAO extends GenericDAO<Candidato> {

	public List<Candidato> buscarPorCargo(List<String> cargos){
		Criteria criteria = getSession().createCriteria(Candidato.class);
		criteria.add(Restrictions.in("cargo", cargos));
		return criteria.list();
	}
	
	public List<Candidato> buscarPorEleicao(Eleicao eleicao){
		Criteria criteria = getSession().createCriteria(EleicaoCandidato.class);
		criteria.add(Restrictions.eq("eleicao", eleicao));
		List<Candidato> candidatos = new ArrayList<>();
		List<EleicaoCandidato> eleicaoCandidatos = criteria.list();
		for (EleicaoCandidato ec : eleicaoCandidatos) {
			candidatos.add(ec.getCandidato());
		}
		return candidatos;
	}
	
}
