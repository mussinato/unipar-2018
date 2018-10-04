package br.unipar.mussinato.singleton.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unipar.mussinato.singleton.domain.Cidade;

public class CidadeDAO {

	private EntityManager em;
	
	public CidadeDAO() {
		em = Conexao.getConexao(); // abre uma conexão
	}
	
	public Cidade salvar(Cidade cidade) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();		
		try {
			cidade = em.merge(cidade);
			transacao.commit();
			return cidade;
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}
	}
}