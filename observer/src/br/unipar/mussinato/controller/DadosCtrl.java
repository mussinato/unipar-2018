package br.unipar.mussinato.controller;

import java.util.ArrayList;
import java.util.List;

import br.unipar.mussinato.controller.observer.DadosObserver;
import br.unipar.mussinato.domain.Dados;

public class DadosCtrl {
	
	private Dados dados;
	private List<DadosObserver> observadores;
	
	public DadosCtrl() {
		observadores = new ArrayList<>();
	}
	
	public void addObservador(DadosObserver observador) {
		observadores.add(observador);
	}
	
	public void setDados(Dados dados) {
		System.out.println("\n== Adicionando dados "+dados+" ==");
		this.dados = dados;
		atualizarObservadores();
	}
	
	private void atualizarObservadores() {
		for (DadosObserver ob : observadores) {
			ob.atualizar(dados);
		}
	}
	
	public Dados getDados() {
		return dados;
	}
		
}
