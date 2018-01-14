package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

public class PesquisaContatoLogic implements Logica {

	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
			
		int id;		
		try {			
			id = Integer.parseInt(req.getParameter("id"));			
		} catch (Exception e) {
			id = 0;		}
		
		if (id > 0) {
			//se existe id, então é edição de contato
			id = Integer.parseInt(req.getParameter("id"));
			Contato contato = new ContatoDao().pesquisaContato(id);
			
			req.setAttribute("contato", contato);		
			System.out.println(">>>>>>>>>>>> Pesquisando contato");
			
			return "WEB-INF/jsp/edita-contato.jsp";
		}else {			
			return "WEB-INF/jsp/adiciona-contato-2.jsp";
		}
	}

}
