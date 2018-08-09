package br.unipar.jsfaula.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.hibernate.Session;

public class GenericDAO<T> {

	private EntityManager em;
	private Session session;

	public GenericDAO() {
		em = Conexao.getConexao(); 
		session = em.unwrap(Session.class);
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
	
	public void excluir(T t) {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();	
		try {
			em.remove(t);
			transacao.commit();
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}		
	}
	
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(Class<T> entidade){
		return session.createCriteria(entidade).list();
	}
}