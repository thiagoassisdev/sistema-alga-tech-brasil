package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.dao.MedicaoDAO;

public class TesteDeletarMedicao {

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		MedicaoDAO dao = new MedicaoDAO();

		int idMedicao = inteiro("Insira o ID da medicao a ser deletada:");

		System.out.println(dao.deletar(idMedicao));
	}
}