package br.unipar.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

import br.unipar.dao.UsuarioDAO;
import br.unipar.domain.Usuario;

public class LoginView extends JFrame {
	private JTextField txtUsuario;
	private JPasswordField txtSenha;
	
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(339, 200);
		this.setTitle("Login");
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		
		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		
		txtSenha = new JPasswordField();
		
		JLabel lblSenha = new JLabel("Senha");
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				UsuarioDAO dao = new UsuarioDAO();
				try {
				
					List<Usuario> usuarios = dao.buscar(
							txtUsuario.getText(), 
							new String(txtSenha.getPassword()));
				
					if (usuarios.isEmpty()) {
						throw new Exception("Usuário e/ou senha inválido(s).");
					} 
					// FECHA A TELA DE LOGIN
					setVisible(false); // ou dispose();
					
					// ABRE A TELA PRINCIPAL DO SISTEMA
					PedagioView pedagioView = new PedagioView();
					
					JOptionPane.showMessageDialog(null, 
							"Bem vindo "+usuarios.get(0).getNome());
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,e.getMessage());
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(14)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnEntrar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblSenha)
								.addComponent(lblUsurio))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(txtSenha)
								.addComponent(txtUsuario, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE))))
					.addGap(24))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(46)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtUsuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsurio))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSenha))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnEntrar, GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
		this.setVisible(true);
	}
}
