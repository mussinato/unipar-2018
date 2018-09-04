package br.unipar.jsfaula.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name="votacaoBean")
@ViewScoped
public class VotacaoBean {

	private String numero = "";
	
	public void corrige() {
		numero = "";
	}
	
	public void setNumero1() {
		numero += "1";
	}

	public void setNumero2() {
		numero += "2";
	}

	public void setNumero3() {
		numero += "3";
	}

	public void setNumero4() {
		numero += "4";
	}

	public void setNumero5() {
		numero += "5";
	}

	public void setNumero6() {
		numero += "6";
	}

	public void setNumero7() {
		numero += "7";
	}

	public void setNumero8() {
		numero += "8";
	}

	public void setNumero9() {
		numero += "9";
	}

	public void setNumeroZero() {
		numero += "0";
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
}
