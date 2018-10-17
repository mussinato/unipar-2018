package br.unipar.mussinato.domain;

public class Dados {
	private int valorA, valorB, valorC;
	 
    public Dados(int a, int b, int c) {
        valorA = a;
        valorB = b;
        valorC = c;
    }

	public int getValorA() {
		return valorA;
	}

	public void setValorA(int valorA) {
		this.valorA = valorA;
	}

	public int getValorB() {
		return valorB;
	}

	public void setValorB(int valorB) {
		this.valorB = valorB;
	}

	public int getValorC() {
		return valorC;
	}

	public void setValorC(int valorC) {
		this.valorC = valorC;
	}
    
	@Override
	public String toString() {
		return String.format("[%d,%d,%d]", valorA, valorB, valorC);
	}
    
}
