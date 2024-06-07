package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.dao.ColheitaDAO;

public class TesteDeletarColheita {
	
	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos 
		ColheitaDAO dao = new ColheitaDAO();
		
		int idColheita = inteiro("Digite o ID da colheita a ser deletada: ");
		
		System.out.println(dao.deletar(idColheita));
	}
}