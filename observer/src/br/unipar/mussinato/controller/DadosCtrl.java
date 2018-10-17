package br.unipar.mussinato.controller;

import br.unipar.mussinato.domain.Dados;

public class DadosCtrl {
	
	private Dados dados;
	
	public DadosCtrl() {
		
	}
	
	public void setDados(Dados dados) {
		System.out.println("\n== Adicionando dados "+dados+" ==");
		this.dados = dados;
	}
	
	public Dados getDados() {
		return dados;
	}
		
}
