package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Funcionario;

public class FuncionarioDAO {

	private Connection connection;

	public FuncionarioDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adicionaFuncionario(Funcionario funcionario) {
		String sql = "insert into funcionarios (nomefun, usuariofun, senhafun) values (?, ?, ?)";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.err.println("Erro ao adicionar Funcionário. Verifique o tamanho das variáveis");
		}
	}

}
