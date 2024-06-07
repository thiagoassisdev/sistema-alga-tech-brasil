package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Colheita;
import br.com.fiap.dao.ColheitaDAO;

public class TesteCadastrarColheita {

	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	static float real(String j) {
		return Float.parseFloat(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		Colheita objColheita = new Colheita();
		ColheitaDAO dao = new ColheitaDAO();

		objColheita.setIdFazenda(inteiro("ID da Fazenda"));
		objColheita.setData(java.sql.Date.valueOf(texto("Informe a data, no formato: (yyyy-mm-dd):")));
		objColheita.setQuantidade(real("Informe a quantidade"));

		System.out.println(dao.inserir(objColheita));
	}
}