import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Principal {

	public static void main(String[] args) {
		EntityManager entityManager = Persistence
				.createEntityManagerFactory("AulaPU")
				.createEntityManager();
		
		EntityTransaction transacao = entityManager.getTransaction();
		transacao.begin();
		
		Pessoa pes = new Pessoa();
		pes.setCodigo(3L);
		pes.setPrimeiroNome("Renato");
		pes.setUltimoNome("Alterado");
		pes.setDataNascimento(new Date());
		pes.setAltura(1.9);
		
		entityManager.merge(pes);
		
		System.out.println("CODIGO: "+pes.getCodigo());
		
		transacao.commit();
		entityManager.close();
	}

}
