package br.unipar.mussinato.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String usuario = req.getParameter("usuario");
		String senha = req.getParameter("senha");
		
		if (usuario != null && usuario.equals("admin@bol.com.br") &&
				senha != null && senha.equals("123")) {
			req.getSession().setAttribute("usuarioLogado", usuario);
			resp.sendRedirect("index.jsp");
		} else {
			req.getSession().setAttribute("mensagem", 
					"Usuário e/ou senha inválido(s).");
			resp.sendRedirect("login.jsp");
		}
	}
}
