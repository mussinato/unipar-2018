package br.unipar.mussinato.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

@WebServlet("/consultaCep")
public class ConsultaCep extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cep = req.getParameter("cep");
		System.out.println(cep);
		
		PrintWriter out = resp.getWriter();
		out.println("<h1>CEP: "+cep+"</h1>");
		
		if (cep != null){
			ViaCEPClient client = new ViaCEPClient();
			ViaCEPEndereco endereco = client.getEndereco(cep);
			out.println("Cep: "+endereco.getCep()+"<br/>");
			out.println("Logradouro: "+endereco.getLogradouro()+"<br/>");
			out.println("Bairro: "+endereco.getBairro()+"<br/>");
			out.println("Localidade: "+endereco.getLocalidade()+"<br/>");
			out.println("Uf: "+endereco.getUf()+"<br/>");
			out.println("Complemento: "+endereco.getComplemento()+"<br/>");
			out.println("Ibge: "+endereco.getIbge()+"<br/>");
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
