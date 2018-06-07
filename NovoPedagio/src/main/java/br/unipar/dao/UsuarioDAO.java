package br.unipar.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unipar.domain.Usuario;

public class UsuarioDAO {

	private Connection conn;
	
	public UsuarioDAO() {
		conn = Conexao.getConnection();
	}
	
	public List<Usuario> buscar(String user, String pass) throws SQLException{
		List<Usuario> lista = new ArrayList<Usuario>();
		
		String sql = "SELECT * FROM USUARIO "
				   + " WHERE USUARIO = ?"
				   + "   AND SENHA   = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, user);
		stmt.setString(2, pass);
		ResultSet result = stmt.executeQuery();
		
		while (result.next()) {
			Usuario usuario = new Usuario();
			usuario.setCodigo(result.getInt("CODIGO"));
			usuario.setNome(result.getString("NOME"));
			usuario.setUsuario(result.getString("USUARIO"));
			usuario.setSenha(result.getString("SENHA"));
			
			lista.add(usuario);
		}
		
		conn.close();
		
		return lista;
	}
	
}
