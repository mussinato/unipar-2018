import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tab_pessoa")
public class Pessoa {

	@Id 
	private Long codigo;
	
	@Column(name="primeiro_nome")
	private String primeiroNome;
	
	@Column(name="segundo_nome")
	private String ultimoNome;
	
	@Column(name="data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(scale=1, precision=2)
	private Double altura;
}









