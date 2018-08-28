import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unipar.dao.PedagioDAO;
import br.unipar.domain.Pedagio;

public class PedagioTest {
	
	private Pedagio criarPedagio() throws SQLException {
		Pedagio p = new Pedagio();
		p.setData(new Date());
		p.setPlaca("AAA-1111");
		p.setValorTotal(10.0);
		p.setValorRecebido(20.0);
		p.setValorTroco(10.0);
		PedagioDAO dao = new PedagioDAO();
		dao.cadastrar(p);
		return consultaUltimo();
	}
	
	private Pedagio consultaUltimo() throws SQLException {
		PedagioDAO dao = new PedagioDAO();
		List<Pedagio> listaConsulta = dao.pesquisar();
		Pedagio ultimo = listaConsulta.get(listaConsulta.size()-1);
		return ultimo;
	}
	
	@Test
	public void cadastrarSucesso() {		
		try {
			Pedagio p = criarPedagio();			
			Pedagio ultimo = consultaUltimo();
			Assert.assertEquals(p.getPlaca(), ultimo.getPlaca());
			Assert.assertEquals(p.getValorRecebido(), ultimo.getValorRecebido());
			Assert.assertEquals(p.getValorTotal(), ultimo.getValorTotal());
			Assert.assertEquals(p.getValorTroco(), ultimo.getValorTroco());
			
		} catch (SQLException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
	
	@Test
	public void excluirSucesso() {
		try {
			Pedagio p = criarPedagio();
			PedagioDAO dao = new PedagioDAO();
			dao.excluir(p.getCodigo());
			
			Pedagio ultimo = consultaUltimo();
			Assert.assertNotEquals(p.getCodigo(), ultimo.getCodigo());
		} catch (SQLException e) {
			e.printStackTrace();
			Assert.fail();
		}
	}
}
