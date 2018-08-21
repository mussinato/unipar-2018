import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.unipar.dao.UsuarioDAO;
import br.unipar.domain.Usuario;

public class UsuarioTest {

	@Test
	public void buscarTestSucesso() {
		UsuarioDAO dao = new UsuarioDAO();
		try {
			List<Usuario> lista = dao.buscar("UNIPAR", "123");
			
			Assert.assertNotNull("Lista está nula",lista);
			Assert.assertTrue("Nenhum usuario encontrado",lista.size() > 0);
			
			for (Usuario user : lista) {
				Assert.assertEquals("UNIPAR", user.getUsuario());
				Assert.assertEquals("123", user.getSenha());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			Assert.fail("Erro não esperado: "+e.getMessage());
		}
	}
	
	@Test
	public void buscarComParametrosNulos() {
		UsuarioDAO dao = new UsuarioDAO();
		try {
			List<Usuario> lista = dao.buscar(null, null);			
			Assert.assertTrue(lista.size() == 0);			
		} catch (SQLException e) {
			Assert.fail();
		}
	}	
}
