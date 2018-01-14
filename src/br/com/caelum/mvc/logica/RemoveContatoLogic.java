package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class RemoveContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Contato contato = new Contato();
		contato.setId(id);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		//ContatoDao dao = new ContatoDao();
		ContatoDao dao = new ContatoDao(connection);
		dao.remove(contato);
		
		System.out.println("Excluindo contato...");
		
		//return "lista-contatos.jsp"; 
		//lista-contatos.jsp ---> Não vai funcionar, o contato será vazio na lista-contatos, 
		//então não retornará uma lista
		return "mvc?logica=ListaContatosLogic";
	}

}
