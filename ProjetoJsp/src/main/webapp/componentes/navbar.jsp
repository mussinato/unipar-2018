<nav class="navbar navbar-dark fixed-top bg-dark flex-md-nowrap p-0 shadow">
	<a class="navbar-brand col-sm-3 col-md-2 mr-0" href="#">Hello World JSP</a>
	<ul class="navbar-nav px-3">      
		<%
			String usuarioLogado = (String) session.getAttribute("usuarioLogado");
			if (usuarioLogado != null){
				out.print("<li class=\"nav-item text-nowrap\">"+
						    "<a class=\"nav-link\" "+ 
						    "href=\"logout\">Sair</a>"+
						  "</li>");				
			}
		%>              
    </ul>
</nav>
