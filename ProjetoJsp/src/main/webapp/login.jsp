<html>
<head>
	<link rel="stylesheet" href="resources/css/login.css">
	<%@ include file="/componentes/imp-bootstrap.jsp" %>
</head>
<body class=text-center>
	<%@ include file="/componentes/navbar.jsp" %>
	
	<form class="form-signin" method="post" action="login">
	  
	  <img class="mb-4" src="resources/images/logo.png" alt="" width="100" height="100">
      
      <%
        session.setAttribute("usuarioLogado", null);
	  	String mensagem = (String) session.getAttribute("mensagem");
	    if (mensagem != null){
	    	session.setAttribute("mensagem", null);	    	
	    	out.println("<div class=\"alert alert-danger\" role=\"alert\"> "+mensagem+"</div>");
	    }
	  %>
		
      <label for="inputEmail" class="sr-only">E-mail</label>
      <input type="email" id="inputEmail" name="usuario" class="form-control" placeholder="E-mail" required="" autofocus="">
      
      <label for="inputPassword" class="sr-only">Senha</label>
      <input type="password" id="inputPassword" name="senha" class="form-control" placeholder="Senha" required="">
      
      <div class="checkbox mb-3">
        <label>
          <input type="checkbox" value="remember-me"> Esqueci minha senha
        </label>
      </div>
      
      <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
      
      <p class="mt-5 mb-3 text-muted">© 2018</p>
    </form>
</body>
</html>
