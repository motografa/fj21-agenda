package br.com.caelum.mvc.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControllerServlet() {
        super();
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	super.service(request, response);
    	
    	String parametro = request.getParameter("logica");
    	String nomeDaClasse =  "br.com.caelum.mvc.logica." + parametro;
    	//System.err.println(">>>parametro: " + parametro);
    	//System.err.println(">>>nomeDaClasse: " + nomeDaClasse);
    	
    	try {
    		Class classe = Class.forName(nomeDaClasse);
    		Logica logica = (Logica) classe.newInstance();
    		String pagina = logica.executa(request, response);
    		
    		request.getRequestDispatcher(pagina).forward(request, response);
			
		} catch (Exception e) {
			throw new ServletException("A lógica da pagina causou uma exceção", e);
			//System.err.println("A lógica da pagina causou uma exceção");
		}
    }


	 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	 

}
