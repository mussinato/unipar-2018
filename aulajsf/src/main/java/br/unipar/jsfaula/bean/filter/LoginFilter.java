package br.unipar.jsfaula.bean.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.unipar.jsfaula.bean.Sessao;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain) throws IOException, ServletException {
		long inicio = System.currentTimeMillis();
		
		if (Sessao.getUsuarioLogado() != null) {
			chain.doFilter(req, res);
		} else {
			HttpServletRequest request = (HttpServletRequest) req;
			HttpServletResponse response = (HttpServletResponse) res;
			response.sendRedirect(
						request.getContextPath() + "/login.xhtml"
					);
		}
		
		long fim = System.currentTimeMillis();
		long resultado = fim - inicio;
		System.out.println("Tempo de processamento: "+resultado+" ms");
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
