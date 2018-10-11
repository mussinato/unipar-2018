package br.unipar.mussinato.adapter.dao;

import br.unipar.mussinato.adapter.domain.Endereco;

public class EnderecoDAO {

	public void salvar(Endereco endereco) {
		System.out.println("Salvando endereco");
		System.out.println("CODIGO: "+endereco.getCodigo());
		System.out.println("ENDERECO: "+endereco.getEndereco());
		System.out.println("BAIRRO: "+endereco.getBairro());
		System.out.println("CIDADE: "+endereco.getCidade());
		System.out.println("ESTADO: "+endereco.getEstado());
		System.out.println("COMPLEMENTO: "+endereco.getComplemento());
		System.out.println("CEP: "+endereco.getCod_cep());
	}
}
