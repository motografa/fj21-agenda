package br.com.caelum.agenda.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.print.PrinterJobWrapper;

/**
 * Servlet implementation class MinhaServlet
 */
@WebServlet("/MinhaServlet")
public class MinhaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MinhaServlet() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
    	super.init(config);
    	log("Iniciando a Servlet!");
    }
    
    public void destroy() {
    	super.destroy();
    	log("Destruindo a servlet!");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//
		out.println("<html>");
		out.println("<body>");
		out.println("...Corpo do service e os paranaues que ele faz...");
		out.println("</body>");
		out.println("</html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
