package br.unipar.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.unipar.domain.Pessoa;

public class PessoaDAO {
	
	private EntityManager em;

	public PessoaDAO() {
		em = Conexao.getConexao();
	}
	
	public Pessoa salvar(Pessoa pessoa) throws Exception {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();		
		try {
			pessoa = em.merge(pessoa);
			transacao.commit();
			return pessoa;
		} catch (Exception ex) {
			transacao.rollback();
			throw ex;
		}
	}
	
	public void excluir(Pessoa pessoa) {
		EntityTransaction transacao = em.getTransaction();
		transacao.begin();	
		em.remove(pessoa);
		transacao.commit();
	}
}
