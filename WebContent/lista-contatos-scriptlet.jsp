<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="br.com.caelum.dao.ContatoDao"%>
<%@page import="br.com.caelum.modelo.Contato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Testin</title>
</head>
<body>
	<table border="1">
	<tr>
	<td>Nome</td> <td>E-mail</td> <td>Endereço</td> <td>Data Nasc.</td>
	</tr>
	
	<%ContatoDao dao = new ContatoDao();
	List<Contato> contatos = dao.getLista();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		for(Contato contato : contatos){
	%>
	
	<tr>
	<td><%= contato.getNome() %></td>
	<td><%= contato.getEmail() %></td>
	<td><%= contato.getEndereco() %></td>
	<td><%= sdf.format(contato.getDataNascimento().getTime()) %></td>
	</tr>
		<%
	}
	%>
	</table>
</body>
<!-- 
Sobre displaytags
http://hotwork.sourceforge.net/hotwork/manual/displaytag/displaytag-user-guide.html#Introdu%C3%A7%C3%A3o
 -->
</html>