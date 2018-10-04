package br.unipar.mussinato.singleton.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Conexao {
	
	private static EntityManager em = null;
	
	public static EntityManager getConexao() {
		if (em == null) {
			System.out.println("Abrindo conexão com o banco");
			em = Persistence
					.createEntityManagerFactory("AulaPU")
					.createEntityManager();
		}
		return em;
	}
}