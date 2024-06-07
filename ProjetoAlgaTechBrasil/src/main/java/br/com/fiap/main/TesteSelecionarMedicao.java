package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Medicao;
import br.com.fiap.dao.MedicaoDAO;

public class TesteSelecionarMedicao {



	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		MedicaoDAO dao = new MedicaoDAO();

		// Selecionar todas as qualidades
		List<Medicao> listaMedicao = (ArrayList<Medicao>) dao.selecionar();

		if (listaMedicao != null) {
			// foreach
			for (Medicao medicao : listaMedicao) {
				System.out.println(medicao.getIdFazenda() + " " + medicao.getIdSensor() + " " 
						+ medicao.getIdFazenda() + " " + medicao.getValor() + " "
						+ medicao.getDataHora() + " " + medicao.getClima());
			}

		}
	}
}