<%@ page import="com.github.gilbertotorrezan.viacep.se.ViaCEPClient" %>
<%@ page import="com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco" %>
<html>
<body>
<%
	String cep = request.getParameter("cep");
	
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
%>
</body>
</html>
