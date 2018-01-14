<%@page import="java.util.List"%>
<%@page import="br.com.caelum.modelo.Contato"%>
<%@page import="br.com.caelum.dao.ContatoDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- Comentario JSP: primeira servlet JSP--%>
	<%-- PÁGINA 88--%>

	<%
		String mensagem = "Bem vindo ao sistema de agenda do FJ-21!!!";
	%>
	<%
		out.println(mensagem);
	%>
	<br />

	<%
		String desenvolvido = "Desenvolvido por um lokão!!!";
	%>

	<%=desenvolvido%>

	<%
		System.out.println("Tudo foi executado!!!");
	%>

	<%
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		for (Contato contato : contatos) {
	%>
	<ul>
	<li><%=contato.getNome()%>, <%=contato.getEmail()%>: <%=contato.getEndereco()%></li>
	</ul>
	<%
		}
	%>
</body>
</html>