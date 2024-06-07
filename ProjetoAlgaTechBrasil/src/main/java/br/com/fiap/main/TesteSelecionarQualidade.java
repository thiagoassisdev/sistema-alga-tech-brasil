package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Qualidade;
import br.com.fiap.dao.QualidadeDAO;

public class TesteSelecionarQualidade {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		QualidadeDAO dao = new QualidadeDAO();

		// Selecionar todas as qualidades
		List<Qualidade> listaQualidade = (ArrayList<Qualidade>) dao.selecionar();

		if (listaQualidade != null) {
			// foreach
			for (Qualidade qualidade : listaQualidade) {
				System.out.println(qualidade.getIdQualidade() + " " + qualidade.getIdFazenda() + " " + qualidade.getData() + " " + qualidade.getPh() + " "
						+ qualidade.getSalinidade() + " " + qualidade.getTemperatura() + " "
						+ qualidade.getNutrientes());
			}

		}
	}
}