package br.unipar.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	
	public static Connection getConnection() {
		try {
			Connection conn = DriverManager
					.getConnection("jdbc:mysql://localhost/pedagio",
							"root","");
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Erro ao abrir conexão\n\n"+e.getMessage());
			return null;
		}
	}
	
}
