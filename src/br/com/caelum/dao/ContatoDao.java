package br.com.caelum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.modelo.Contato;

public class ContatoDao {

	private Connection connection;

	public ContatoDao(Connection connection) {
		this.connection = connection;
	}

	public ContatoDao() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Contato contato) {
		String sql = "INSERT INTO contatos (nome, email, endereco, dataNascimento) VALUES (?, ?, ?, ?)";
		try {
			// prepared Statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			// seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));

			// executa
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.err.println("Erro ao adicionar conta");
		}
	}

	// pag 35
	public List<Contato> getLista() {
		List<Contato> contatos = new ArrayList<>();
		try {
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from contatos");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				// Criando o objeto conato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));

				// montando a data através do calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);

				// adicionando na lista de contatos
				contatos.add(contato);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			// throw new RuntimeException(e);
			DAOException daoE = new DAOException();
			daoE.BillaException(e);
		}
		return contatos;
	}

	// pag 37
	public Contato pesquisaContato(int i) {
		Contato contato = new Contato();
		try {
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from contatos where id = " + i);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEndereco(rs.getString("endereco"));
				contato.setEmail(rs.getString("email"));

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
			}
			rs.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println("Erro ao pesquisar contato");

		}

		return contato;
	}

	public void altera(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=? where id=?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			stmt.setLong(5, contato.getId());

			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.err.println("Erro ao editar contato");
		}
	}

	public void remove(Contato contato) {
		String sql = "delete from contatos where id = ?";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			System.err.println("Erro ao deletar contato");
		}

	}

}
