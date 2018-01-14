
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista contatos</title>
</head>
<body>

	<c:import url="cabecalho.jsp" />

	<!--  01 -->
	<!-- <jsp:useBean id="dao" class="br.com.caelum.dao.ContatoDao"></jsp:useBean> -->
	<table>

		<tr bgcolor='BBFFFF'>
			<td>Nome</td>
			<td>Email</td>
			<td>Endereço</td>
			<td>Nascimento</td>
			<td>
			<a href="mvc?logica=PesquisaContatoLogic"> <Strong>Novo Contato</Strong></a>
			</td>

		</tr>

		<c:forEach var="contato" items="${contatos}" varStatus="id">
		<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }">
				<td>${contato.nome}</td>
				
				<td><c:if test="${not empty contato.email}">
					<a href="mailto:${contato.email}">${contato.email}</a>
					</c:if> 
					<c:if test="${empty contato.email}">
							E-mail não informado			
					</c:if>
				</td>
				
				<td>${contato.endereco}</td>	
				
							
				<!-- <td>${contato.dataNascimento.time}</td> -->	
				<td>
				<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" />
				</td>
				
				<td>
				<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>
				</td>
				
				<td>
				<a href="mvc?logica=PesquisaContatoLogic&id=${contato.id}">Alterar</a>
				</td>
								
				
			</tr>
		</c:forEach>
	</table>
	
		<c:import url="rodape.jsp" />
</body>

<!-- 
Sobre displaytags
http://hotwork.sourceforge.net/hotwork/manual/displaytag/displaytag-user-guide.html#Introdu%C3%A7%C3%A3o
 -->
</html>