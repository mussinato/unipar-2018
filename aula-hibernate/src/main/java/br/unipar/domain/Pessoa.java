package br.unipar.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_pessoa")
public class Pessoa {

	@Id 
	@GeneratedValue
	private Long codigo;
	
	@Column(name="primeiro_nome", length=50, nullable=false)
	private String primeiroNome;
	
	@Column(name="segundo_nome", length=50, nullable=false)
	private String ultimoNome;
	
	@Column(name="data_nascimento", nullable=false)
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@ManyToOne
	@JoinColumn(name="cidade") // alterar o nome do campo da FK
	private Cidade cidade;
	
	@Column(scale=1, precision=2, nullable=true)
	private Double altura;

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getPrimeiroNome() {
		return primeiroNome;
	}

	public void setPrimeiroNome(String primeiroNome) {
		this.primeiroNome = primeiroNome;
	}

	public String getUltimoNome() {
		return ultimoNome;
	}

	public void setUltimoNome(String ultimoNome) {
		this.ultimoNome = ultimoNome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}









