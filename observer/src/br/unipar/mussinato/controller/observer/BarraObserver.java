package br.unipar.mussinato.controller.observer;

import br.unipar.mussinato.domain.Dados;

public class BarraObserver implements DadosObserver {

	@Override
	public void atualizar(Dados dados) {
		String barraA = String.format("%"+dados.getValorA()+"s", "").replace(' ', '=');
		String barraB = String.format("%"+dados.getValorB()+"s", "").replace(' ', '=');
		String barraC = String.format("%"+dados.getValorC()+"s", "").replace(' ', '=');
		
		System.out.println("* Gráfico de barras");
		System.out.println("A:"+barraA+" ["+dados.getValorA()+"]");
		System.out.println("B:"+barraB+" ["+dados.getValorB()+"]");
		System.out.println("C:"+barraC+" ["+dados.getValorC()+"]");
	}

}
