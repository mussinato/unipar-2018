package br.unipar.mussinato.controller.observer;

import br.unipar.mussinato.domain.Dados;

public class PizzaObserver implements DadosObserver {

	@Override
	public void atualizar(Dados dados) {
		int total = dados.getValorA() + dados.getValorB() + dados.getValorC();
		int porValorA = (dados.getValorA() * 100) / total;
		int porValorB = (dados.getValorB() * 100) / total;
		int porValorC = (dados.getValorC() * 100) / total;
		
		System.out.println("* Gráfico de pizza");
		System.out.println("A: "+porValorA+"%");
		System.out.println("B: "+porValorB+"%");
		System.out.println("C: "+porValorC+"%");
	}

}
