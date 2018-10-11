package br.unipar.mussinato.adapter;

import javax.swing.JOptionPane;

import br.unipar.mussinato.adapter.controller.EnderecoController;

public class Principal {
	public static void main(String[] args) {
		String cep = new JOptionPane().showInputDialog("Informe um cep para consulta:");
		if (cep != null && !cep.equals("")) {
			EnderecoController ctrl = new EnderecoController();
			try {
				ctrl.consultarEndereco(cep);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
				e.printStackTrace();
			}
		}
		System.exit(0);
	}
}
