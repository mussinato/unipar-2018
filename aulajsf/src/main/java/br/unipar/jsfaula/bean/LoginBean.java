package br.unipar.jsfaula.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.unipar.jsfaula.dao.UsuarioDAO;
import br.unipar.jsfaula.domain.Usuario;

@ManagedBean(name="loginBean")
@ViewScoped
public class LoginBean {
	private String usuario;
	private String senha;
	
	public String login() {
		UsuarioDAO dao = new UsuarioDAO();
		Usuario user = dao.login(usuario, senha);
		if (user != null) {
			Sessao.setUsuarioLogado(user);
			return "restrito/index.xhtml";
		}
		return null;
	}
	
	public String logout() {
		Sessao.setUsuarioLogado(null);
		return "/login.xhtml";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
