package br.com.caelum.agenda.filtro;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.mysql.jdbc.Connection;

import br.com.caelum.jdbc.ConnectionFactory;

@WebFilter("/*")
public class FiltroConexao implements Filter {

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		try {
			Connection connection = (Connection) new ConnectionFactory().getConnection();

			// "pendeura" um objeto no request
			request.setAttribute("conexao", connection);

			// indica que processamento do request deve prosseguir
			chain.doFilter(request, response);

			connection.close();
		} catch (SQLException e) {
			throw new ServletException(e);
		}

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

}
