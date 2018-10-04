package br.unipar.mussinato.singleton;

import javax.swing.JOptionPane;

import br.unipar.mussinato.singleton.dao.CidadeDAO;
import br.unipar.mussinato.singleton.domain.Cidade;

public class Principal {
	public static void main(String[] args) {
		System.out.println("Iniciando a aplicação");
		
		System.out.println("Criando a cidade 1");
		Cidade cid = new Cidade();
		cid.setNome("CIANORTE");
		cid.setUf("PR");
		CidadeDAO cidDAO = new CidadeDAO();
		try {
			System.out.println("Salvando a cidade 1");
			cid = cidDAO.salvar(cid);
			System.out.println("Cidade 1 cadastrada");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
		
		System.out.println("Criando a cidade 2");
		Cidade cid2 = new Cidade();
		cid2.setNome("CIANORTE");
		cid2.setUf("PR");
		CidadeDAO cidDAO2 = new CidadeDAO();
		try {
			System.out.println("Salvando a cidade 2");
			cid2 = cidDAO2.salvar(cid2);
			System.out.println("Cidade 2 cadastrada");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
		
		System.out.println("Criando a cidade 3");
		Cidade cid3 = new Cidade();
		cid3.setNome("TERRA BOA");
		cid3.setUf("PR");
		CidadeDAO cidDAO3 = new CidadeDAO();
		try {
			System.out.println("Salvando a cidade 3");
			cid3 = cidDAO3.salvar(cid3);
			System.out.println("Cidade 3 cadastrada");
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
			e1.printStackTrace();
		}
		
		System.out.println("Finalizando a aplicação");
		System.exit(0);
	}
}
