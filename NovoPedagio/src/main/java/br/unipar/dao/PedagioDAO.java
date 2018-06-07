package br.unipar.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.unipar.domain.Pedagio;

public class PedagioDAO {

	private Connection conn;
	
	// ESSE É O METODO CONSTRUTOR
	public PedagioDAO() {
		conn = Conexao.getConnection(); // ABRE CONEXAO COM O BANCO
	}
	
	public void cadastrar(Pedagio pedagio) throws SQLException {
		
		// CODIGO PARA EXECUTAR O INSERT NO BANCO
		String sql = "INSERT INTO PEDAGIO "
				+ "(VLR_TOTAL,VLR_RECEBIDO,VLR_TROCO,PLACA,DATA) "
				+ "VALUES (?,?,?,?,?)";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setDouble(1, pedagio.getValorTotal());
		stmt.setDouble(2, pedagio.getValorRecebido());
		stmt.setDouble(3, pedagio.getValorTroco());
		stmt.setString(4, pedagio.getPlaca());
		stmt.setDate(5, new Date( pedagio.getData().getTime() ));		
		stmt.execute();
		stmt.close();
	}
	
	public void excluir(Integer codigo) throws SQLException {
		String sql = "DELETE FROM PEDAGIO "
				+ "WHERE CODIGO = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, codigo);
		stmt.execute();
		stmt.close();
	}
	
	public List<Pedagio> pesquisar() throws SQLException{
		List<Pedagio> resultado = new ArrayList<Pedagio>();
		
		// CODIGO PARA PESQUISAR OS REGISTROS NO BANCO
		String sql = "SELECT * FROM PEDAGIO";
		PreparedStatement stmt = conn.prepareStatement(sql);
		ResultSet list = stmt.executeQuery();
		
		while (list.next()) {
			Pedagio ped = new Pedagio();
			ped.setCodigo(list.getInt("CODIGO"));
			ped.setData(list.getDate("DATA"));
			ped.setPlaca(list.getString("PLACA"));
			ped.setValorRecebido(list.getDouble("VLR_RECEBIDO"));
			ped.setValorTotal(list.getDouble("VLR_TOTAL"));
			ped.setValorTroco(list.getDouble("VLR_TROCO"));
			
			resultado.add(ped);
		}
		
		stmt.close();
		return resultado;
	}
	
}




