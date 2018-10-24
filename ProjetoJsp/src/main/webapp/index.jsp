<%
	String helloWorld = "Hello World with JSP";
	String param = request.getParameter("param");
	
	if (param == null){
		param = "";
	}
%>
<html>
<body>
	<h2>Hello World!</h2>
	<h2><%= helloWorld %></h2>
	<h3>Parametro: <%= param %></h3>
	
	<form method="post" action="resultado.jsp">
		<input type="text" name="texto" value="<%= param %>" />
		<button type="submit">Enviar</button>
	</form>
</body>
</html>
