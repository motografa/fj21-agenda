package br.com.caelum.dao;

public class DAOException extends RuntimeException {

	// construtor
	public DAOException() {
		super("Erro desconhecido");
	}

	// Aqui a sobreescrita do construtor que recebe como parametro uma String
	public DAOException(String e) {
		super(e);
	}

	public void BillaException(Exception e) {
		// TODO Auto-generated method stub
		System.out.println(e);
	}
}
