package br.unipar.jsfaula.bean;

import br.unipar.jsfaula.domain.Usuario;

public class Sessao {
	private static Usuario usuarioLogado;

	public static Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public static void setUsuarioLogado(Usuario usuarioLogado) {
		Sessao.usuarioLogado = usuarioLogado;
	}
	
	
}
