package br.unipar.jsfaula.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Conexao {
	
	private static EntityManager em;
	
	public static EntityManager getConexao() {
		if (em == null) {
			em = Persistence
					.createEntityManagerFactory("AulaPU")
					.createEntityManager();
		}
		return em;
	}
}