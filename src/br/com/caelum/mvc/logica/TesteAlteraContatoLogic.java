package br.com.caelum.mvc.logica;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TesteAlteraContatoLogic implements Logica {

	@SuppressWarnings("unused")
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();

		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		// Calendar dataNascimento = null;

		/*
		 * //convers�o da data try { Date date = new
		 * SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto); dataNascimento =
		 * Calendar.getInstance(); dataNascimento.setTime(date); } catch
		 * (java.text.ParseException e) { out.println("Erro na convers�o da data");
		 * return;// p�ra a execu��o do m�todo }
		 */

		System.out.println("nome: " + nome);
		System.out.println("endereco: " + endereco);
		System.out.println("email: " + email);
		System.out.println("dataNascimento: " + dataEmTexto);
		return null;
	}

}
