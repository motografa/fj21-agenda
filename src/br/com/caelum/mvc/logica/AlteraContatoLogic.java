package br.com.caelum.mvc.logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;


@WebServlet("/alteraContato")
public class AlteraContatoLogic extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
    public AlteraContatoLogic() {
        super();
    }

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();

		long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;

	
		//conversão da data
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
			System.out.println("dataNascimento millisegundos: " + dataNascimento.getTimeInMillis());
			System.out.println("dataNascimento to string: " + dataNascimento.toString());
			System.out.println("dataNascimento get time: " + dataNascimento.getTime());
		} catch (java.text.ParseException e) {
			System.out.println("Erro na conversão da data");
			return;// pára a execução do método
		}
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		//ContatoDao dao = new ContatoDao();
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		

		System.out.println("id: " + id);
		System.out.println("nome: " + nome);
		System.out.println("endereco: " + endereco);
		System.out.println("email: " + email);
		System.out.println("dataEmTexto: " + dataEmTexto);
		
		ListaContatosLogic listar = new ListaContatosLogic();
		try {
			listar.executa(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/jsp/lista-contatos.jsp");
		rd.forward(request, response);		
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		

	}

}
