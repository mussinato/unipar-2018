package br.unipar.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class GenericDAO<T> {

	private EntityManager em;

	public GenericDAO() {
		em = Conexao.getConexao(); // abre uma conexão
	}
	
	public T salvar(T t) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();		
		try {
			t = em.merge(t);
			transacao.commit();
			return t;
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}
	}
}
