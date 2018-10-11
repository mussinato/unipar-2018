package br.unipar.mussinato.adapter.controller;

import java.io.IOException;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

import br.unipar.mussinato.adapter.dao.EnderecoDAO;
import br.unipar.mussinato.adapter.domain.Endereco;

public class EnderecoController {

	private EnderecoDAO dao = new EnderecoDAO();
	
	public void consultarEndereco(String cep) throws IOException {
		ViaCEPClient client = new ViaCEPClient();
		ViaCEPEndereco end = client.getEndereco(cep);
		
		Endereco endereco = null;
		
		dao.salvar(endereco);
	}
}
