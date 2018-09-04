package aulajsf;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.unipar.jsfaula.dao.CandidatoDAO;
import br.unipar.jsfaula.domain.Candidato;

public class CandidatoTest {
	
	@Before
	public void before() {
		System.out.println("ANTES");
	}
	
	@After
	public void after() {
		System.out.println("DEPOIS");
	}
	
	@BeforeClass
	public static void beforeClass() {
		System.out.println("ANTES CLASS");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("DEPOIS CLASS");
		CandidatoDAO dao = new CandidatoDAO();
		List<Candidato> lista = dao.buscarTodos(Candidato.class);
		for (Candidato c : lista) {
			dao.excluir(c);
		}
	}
	
	@Test
	public void cadastrarSucesso() {
		CandidatoDAO dao = new CandidatoDAO();
		
		Candidato can = new Candidato();
		can.setCodigo( (new Date()).getTime() );
		can.setNome("JOAO DA SILVA");
		can.setPartido("PUNI");
		
		try {
			can = dao.salvar(can);
			
			Candidato verifica = dao.buscarPorCodigo(Candidato.class, 
					can.getCodigo());
			
			Assert.assertNotNull(verifica);
			
		} catch (Exception e) {
			Assert.fail(e.getMessage());
		}
	}
	
	@Test
	public void cadastrarErro() {
		CandidatoDAO dao = new CandidatoDAO();
		
		Candidato can = new Candidato();
		can.setCodigo( null );
		can.setNome(null);
		can.setPartido(null);
		
		try {
			can = dao.salvar(can);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertNotNull(e);
		}
	}
}
