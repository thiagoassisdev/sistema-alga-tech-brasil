package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.dao.SensorDAO;

public class TesteDeletarSensor {

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		SensorDAO dao = new SensorDAO();

		int idSensor = inteiro("Digite o ID do sensor a ser deletado: ");

		System.out.println(dao.deletar(idSensor));
	}
}