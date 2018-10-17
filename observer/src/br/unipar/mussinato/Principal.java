package br.unipar.mussinato;

import br.unipar.mussinato.controller.DadosCtrl;
import br.unipar.mussinato.controller.observer.BarraObserver;
import br.unipar.mussinato.controller.observer.PizzaObserver;
import br.unipar.mussinato.domain.Dados;

public class Principal {
	public static void main(String[] args) {
		DadosCtrl controlador = new DadosCtrl();
		controlador.addObservador(new PizzaObserver());
		controlador.addObservador(new BarraObserver());
		controlador.setDados(new Dados(10, 5, 12));
		controlador.setDados(new Dados(15, 2, 8));
		controlador.setDados(new Dados(12, 18, 15));
	}
}
