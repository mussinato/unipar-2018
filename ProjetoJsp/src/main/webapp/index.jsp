<%
	String helloWorld = "Hello World with JSP";
	String param = request.getParameter("param");
	
	if (param == null){
		param = "";
	}
%>
<html>
<head>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
	<%@ include file="/componentes/navbar.jsp" %>
	
    <h2>Hello World!</h2>
	<h2><%= helloWorld %></h2>
	<h3>Parametro: <%= param %></h3>
	
	<form method="get" action="consultaCep">
		<input type="text" name="cep" value="<%= param %>" />
		<button type="submit">Enviar</button>
	</form>	
</body>
</html>
