<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>Adiciona Contato</title>

	<link href="WebContent/jquery-ui.css" rel="stylesheet">
	<script src="WebContent/jquery.js"></script>
	<script src="WebContent/jquery-ui.js"></script>
	
</head>
<body>

	<h1>Adiciona Contato</h1>
	<hr />
	<form action="adicionaContato" method="post">
	
		Nome: <input type="text" name="nome" /><br /> 
		E-mail: <input type="text" name="email" /><br /> 
		Endereço: <input type="text" name="endereco" /><br /> 
		Data Nascimento: <caelum:campoData id="dataNascimento" /><br />
		<!--  Data Nascimento: <input type="text" name="dataNascimento" /><br />-->
		
		<input type="submit" value="Gravar"/> 
	</form>

</body>
</html>



