package br.unipar.jsfaula.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	@Id
	private Long codigo;
	private String usuario;
	private String sennha;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getSennha() {
		return sennha;
	}
	public void setSennha(String sennha) {
		this.sennha = sennha;
	}	
}
