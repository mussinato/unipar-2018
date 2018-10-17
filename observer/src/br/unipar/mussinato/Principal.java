package br.unipar.mussinato;

import br.unipar.mussinato.controller.DadosCtrl;
import br.unipar.mussinato.domain.Dados;

public class Principal {
	public static void main(String[] args) {
		DadosCtrl controlador = new DadosCtrl();
		controlador.setDados(new Dados(10, 20, 30));
		controlador.setDados(new Dados(15, 25, 30));
		controlador.setDados(new Dados(20, 28, 50));
	}
}
