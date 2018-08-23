package br.unipar.jsfaula.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="eleicao")
public class Eleicao {
	@Id
	@GeneratedValue
	private Long codigo;
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getDataStr() {
		if (data == null) {
			return "";
		}
		return new SimpleDateFormat("dd/MM/yyyy").format(data);
	}
	
}
