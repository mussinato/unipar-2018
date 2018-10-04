package br.unipar.mussinato.singleton.dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Conexao {
	
	public static EntityManager getConexao() {
		System.out.println("Abrindo conexão com o banco");
		return Persistence
				.createEntityManagerFactory("AulaPU")
				.createEntityManager();
	}
}