package br.unipar.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.unipar.dao.PedagioDAO;
import br.unipar.domain.Pedagio;

public class PedagioView extends JFrame {
	
	private JTextField txtValorTotal;
	private JTextField txtValorRecebido;
	private JTextField txtTroco;
	private JTextField txtData;
	private JTable tabela;
	
	private DefaultTableModel modelo = new DefaultTableModel();
	
	public PedagioView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(850,500); // define o tamanho da tela
		
		getContentPane().setBackground(new Color(192, 192, 192));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnCarro = new JButton("<html>Carro<br/>R$ 20,80</html>");
		btnCarro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtValorTotal.setText("20,80");
				
				Date dataAtual = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				txtData.setText(dateFormat.format(dataAtual));
			}
		});
		
		JButton btnMoto = new JButton("<html>Moto<br/>R$ 5,50</html>");
		btnMoto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtValorTotal.setText("5,50");
				
				Date dataAtual = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				txtData.setText(dateFormat.format(dataAtual));				
			}
		});
		
		JButton btnOutros = new JButton("<html>Outros<br/>R$ 30,20</html>");
		btnOutros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtValorTotal.setText("30,20");
				
				Date dataAtual = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				txtData.setText(dateFormat.format(dataAtual));				
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// LINHA SELECIONADA NA TABELA
				int index = tabela.getSelectedRow();
				int coluna = 0;
				
				// OBTER O VALOR DA PRIMEIRA COLUNA DA LINHA SELECIONADA
				Integer codigo = (Integer) tabela.getModel()
						.getValueAt(index, coluna);
				
				// EXCLUIR REGISTRO
				PedagioDAO dao = new PedagioDAO();
				
				if (JOptionPane.showConfirmDialog(null, 
						"Deseja excluir o lancamento?",
						"Atenção!",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				
					try {
						dao.excluir(codigo);
						
						JOptionPane.showMessageDialog(null, 
								"Lancamento excluido com sucesso.");
						
						pesquisar();
					} catch (SQLException e) {
						JOptionPane.showMessageDialog(null, e.getMessage());
						e.printStackTrace();
					}
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 427, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(btnCarro, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnMoto, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnOutros, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 270, Short.MAX_VALUE)
							.addComponent(btnExcluir)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnCarro, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnMoto, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnOutros, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED, 27, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnExcluir)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE))
					.addGap(26))
		);
		
		tabela = new JTable(modelo);
		JScrollPane scrollPane = new JScrollPane(tabela);
		
		// DESABILITA A EDICAO DA CELULA DA TABELA
		tabela.setDefaultEditor(Object.class, null);
		
		modelo.addColumn("Código");
		modelo.addColumn("Placa");
		modelo.addColumn("Vlr Total");
		modelo.addColumn("Vlr Recebido");
		modelo.addColumn("Vlr Troco");
		modelo.addColumn("Data");
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		txtValorTotal = new JTextField();
		txtValorTotal.setBackground(SystemColor.control);
		txtValorTotal.setEditable(false);
		txtValorTotal.setFont(new Font("Dialog", Font.BOLD, 18));
		txtValorTotal.setColumns(10);
		
		JLabel lblValorTotal = new JLabel("Valor Total");
		
		txtValorRecebido = new JTextField();
		txtValorRecebido.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				// evento quando sai do campo
				String valorTxt = txtValorTotal.getText().replace(",", "."); 
				Double valorTotal = Double.parseDouble(valorTxt);
				
				String recebidoTxt = txtValorRecebido.getText().replace(",", ".");
				Double valorRecebido = Double.parseDouble(recebidoTxt);
				
				Double troco = valorRecebido - valorTotal;
				
				txtTroco.setText(troco.toString()
						.format("%1$,.2f", troco) // arredonda para 2 casas
						.replace(".", ","));
			}
		});
		txtValorRecebido.setFont(new Font("Dialog", Font.BOLD, 18));
		txtValorRecebido.setColumns(10);
		
		txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setBackground(SystemColor.control);
		txtTroco.setFont(new Font("Dialog", Font.BOLD, 18));
		txtTroco.setColumns(10);
		
		JLabel lblValorRecebido = new JLabel("Valor Recebido");
		
		JLabel lblTroco = new JLabel("Troco");
		
		JLabel lblPlaca = new JLabel("Placa");
		
		txtData = new JTextField();
		txtData.setEditable(false);
		txtData.setBackground(SystemColor.control);
		txtData.setFont(new Font("Dialog", Font.BOLD, 18));
		txtData.setColumns(10);
		
		MaskFormatter mask = null;
		try {
			mask = new MaskFormatter("UUU-####");
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		final JFormattedTextField txtPlaca = new JFormattedTextField(mask);
		
		
		txtPlaca.setFont(new Font("Dialog", Font.PLAIN, 18));
		
		
		JLabel lblData = new JLabel("Data");
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// coletar as informacoes dos campos
				String valorTxt = txtValorTotal.getText().replace(",", "."); 
				Double valorTotal = Double.parseDouble(valorTxt);
				
				String recebidoTxt = txtValorRecebido.getText().replace(",", ".");
				Double valorRecebido = Double.parseDouble(recebidoTxt);
				
				Double troco = valorRecebido - valorTotal;
				String placa = txtPlaca.getText();
				
				Date data = null;
				try {
					data = new SimpleDateFormat("dd/MM/yyyy")
							.parse(txtData.getText());
				} catch (ParseException e) {
					e.printStackTrace();
				}
				
				Pedagio pedagio = new Pedagio();
				pedagio.setData(data);
				pedagio.setPlaca(placa);
				pedagio.setValorRecebido(valorRecebido);
				pedagio.setValorTotal(valorTotal);
				pedagio.setValorTroco(troco);
				
				// inserir no banco
				PedagioDAO dao = new PedagioDAO();
				try {
					dao.cadastrar(pedagio);
					
					JOptionPane.showMessageDialog(null, 
							"Pedágio cadastrado com sucesso.");
					
					txtValorTotal.setText(null);
					txtValorRecebido.setText(null);
					txtTroco.setText(null);
					txtData.setText(null);
					txtPlaca.setText(null);
					
					pesquisar();
				} catch (SQLException e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(
							null, "Erro: "+e.getMessage());
				}
			}
		});
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(41)
					.addComponent(lblValorTotal)
					.addGap(12)
					.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(39)
					.addComponent(lblPlaca)
					.addGap(12)
					.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(16)
					.addComponent(lblValorRecebido)
					.addGap(12)
					.addComponent(txtValorRecebido, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(45)
					.addComponent(lblData)
					.addGap(12)
					.addComponent(txtData, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(69)
					.addComponent(lblTroco)
					.addGap(12)
					.addComponent(txtTroco, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(95)
					.addComponent(btnFinalizar, GroupLayout.PREFERRED_SIZE, 238, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(lblValorTotal))
						.addComponent(txtValorTotal, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(lblPlaca))
						.addComponent(txtPlaca, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(lblValorRecebido))
						.addComponent(txtValorRecebido, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(lblData))
						.addComponent(txtData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(8)
							.addComponent(lblTroco))
						.addComponent(txtTroco, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(59)
					.addComponent(btnFinalizar, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(null);
		
		JLabel lblPedgio = new JLabel("Pedágio");
		lblPedgio.setForeground(new Color(255, 255, 255));
		lblPedgio.setBackground(new Color(255, 255, 255));
		lblPedgio.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPedgio.setBounds(381, 12, 104, 23);
		panel.add(lblPedgio);
		getContentPane().setLayout(groupLayout);
		
		pesquisar();
		this.setVisible(true); // exibe a tela
	}
	
	
	private void pesquisar() {
		PedagioDAO dao = new PedagioDAO();
		try {
			List<Pedagio> lista = dao.pesquisar();
			
			modelo.setNumRows(0); // LIMPA A TABELA
			
			for (Pedagio p : lista) {
				
				// FORMATAÇÃO DA DATA
				String dataFormatada = new SimpleDateFormat("dd/MM/yyyy")
						.format(p.getData());
				
				// ADICIONA AS LINHAS NA TABELA
				modelo.addRow(new Object[]{p.getCodigo(),
						p.getPlaca(),
						p.getValorTotal(), 
						p.getValorRecebido(),
						p.getValorTroco(),
						dataFormatada});
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, 
					"Erro ao pesquisar\n\n"+e.getMessage());
		}
	}
}




