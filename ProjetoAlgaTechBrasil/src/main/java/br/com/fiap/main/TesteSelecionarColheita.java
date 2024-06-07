package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Colheita;
import br.com.fiap.dao.ColheitaDAO;

public class TesteSelecionarColheita {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		ColheitaDAO dao = new ColheitaDAO();

		List<Colheita> listaColheita = (ArrayList<Colheita>) dao.selecionar();

		if (listaColheita != null) {
			// foreach
			for (Colheita colheita : listaColheita) {
				System.out.println(colheita.getIdColheita() + " " + colheita.getIdFazenda() + " " + colheita.getData() + " " + colheita.getQuantidade());
			}
		}
	}
}	