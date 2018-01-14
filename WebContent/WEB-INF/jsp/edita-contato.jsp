<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edita Contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp" />
	<h1>Edita Contato</h1>
	
	<form action="alteraContato" method="post">

	<table>
		<tr bgcolor='BBFFFF'>
			<td width: 190px></td>
			<td width: 190px>Nome</td>
			<td width: 190px>E-mail</td>
			<td width: 300px>Endereço</td>
			<td width: 100px>Nascimento</td>
		</tr>

		<tr>
		
		<td>
			<input type="hidden" name="id" value="${contato.id}" />
			</td>
			
			<td>
			<input type="text" name="nome" value="${contato.nome}" />
			</td>

			<td>
			<input type="text" name="email" value="${contato.email}" />
			</td>

			<td>
			<input type="text" name="endereco" value="${contato.endereco}" />
			</td>

			<td>
			<input type="text" name=dataNascimento value="<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />" />
			</td>

			<!-- <td>
			<a href="mvc?logica=AlteraContatoLogic&id=${contato.id}">SALVAR</a>
			</td> -->
			
			<td><input type="submit" value="Salvar"/></td>		
									
		</tr>
	</table>
</form>
	<c:import url="rodape.jsp" />
</body>
</html>