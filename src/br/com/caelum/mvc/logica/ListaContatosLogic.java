package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class ListaContatosLogic implements Logica{
	
	public ListaContatosLogic() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		List<Contato> contatos = new ContatoDao().getLista();
		
		req.setAttribute("contatos", contatos);

		return "WEB-INF/jsp/lista-contatos.jsp";			
	}
	
}
