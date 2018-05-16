package br.unipar.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Conexao {
	
	public static EntityManager getConexao() {
		return Persistence
				.createEntityManagerFactory("AulaPU")
				.createEntityManager();
	}
}
