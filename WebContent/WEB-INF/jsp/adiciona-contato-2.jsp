<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Adiciona Contato</title>

	<link href="./jquery-ui.css" rel="stylesheet">
	<script src="./jquery.js"></script>
	<script src="./jquery-ui.js"></script>
	
</head>
<body>
<c:import url="cabecalho.jsp" /> 
	<h1>Adiciona Contato</h1>
	<hr />
	<form action="adicionaContatoLogic" method="post">
	
		Nome: <input type="text" name="nome" /><br /> 
		E-mail: <input type="text" name="email" /><br /> 
		Endereço: <input type="text" name="endereco" /><br /> 
		Data Nascimento: <caelum:campoData id="dataNascimento" /><br />
		<!--  Data Nascimento: <input type="text" name="dataNascimento" /><br />-->
		
		<input type="submit" value="Gravar"/> 
	</form>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>



