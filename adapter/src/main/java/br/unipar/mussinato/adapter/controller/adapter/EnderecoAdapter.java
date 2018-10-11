package br.unipar.mussinato.adapter.controller.adapter;

import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

import br.unipar.mussinato.adapter.domain.Endereco;

public class EnderecoAdapter extends Endereco {

	public EnderecoAdapter(ViaCEPEndereco end) {
		this.setBairro(end.getBairro());
		this.setCidade(end.getLocalidade());
		this.setCod_cep(end.getCep());
		this.setCodigo(end.getIbge());
		this.setComplemento(end.getComplemento());
		this.setEndereco(end.getLogradouro());
		this.setEstado(end.getUf());
	}
	
}
