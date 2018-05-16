import java.util.Date;

import javax.swing.JOptionPane;

import br.unipar.dao.PessoaDAO;
import br.unipar.domain.Pessoa;

public class Principal {

	public static void main(String[] args) {
		Pessoa pes = new Pessoa();
		pes.setPrimeiroNome("Renato");
		pes.setUltimoNome("Alterado");
		pes.setDataNascimento(new Date());
		pes.setAltura(1.9);
		
		PessoaDAO dao = new PessoaDAO();
		try {
			pes = dao.salvar(pes);
			
			JOptionPane.showMessageDialog(null, 
					"Pessoa "+pes.getCodigo()+" salva com sucesso.");
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		
		
	}

}
