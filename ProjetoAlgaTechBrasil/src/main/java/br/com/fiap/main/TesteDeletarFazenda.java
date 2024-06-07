package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.dao.FazendaDAO;

public class TesteDeletarFazenda {

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		FazendaDAO dao = new FazendaDAO();

		int idFazenda = inteiro("Insira o ID da fazenda a ser deletada:");

		System.out.println(dao.deletar(idFazenda));
	}
}