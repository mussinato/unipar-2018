<%
	String helloWorld = "Hello World with JSP";
	String param = request.getParameter("param");
	
	if (param == null){
		param = "";
	}
%>
<html>
<head>
	<%@ include file="../componentes/imp-bootstrap.jsp" %>
</head>
<body>
	<%@ include file="../componentes/navbar.jsp" %>
	
    <h2>Hello World!</h2>
	<h2><%= helloWorld %></h2>
	<h3>Parametro: <%= param %></h3>
	
	<form method="get" action="consultaCep">
		<input type="text" name="cep" value="<%= param %>" />
		<button type="submit">Enviar</button>
	</form>	
</body>
</html>
