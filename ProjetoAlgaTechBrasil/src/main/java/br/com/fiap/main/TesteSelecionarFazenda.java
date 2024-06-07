package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Fazenda;
import br.com.fiap.dao.FazendaDAO;


public class TesteSelecionarFazenda {



	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		FazendaDAO dao = new FazendaDAO();

		// Selecionar todas as qualidades
		List<Fazenda> listaFazenda = (ArrayList<Fazenda>) dao.selecionar();

		if (listaFazenda != null) {
			// foreach
			for (Fazenda fazenda : listaFazenda) {
				System.out.println(fazenda.getIdFazenda() + " " + fazenda.getNome() + " " 
						+ fazenda.getLocalizacao() + " " + fazenda.getCep() + " "
						+ fazenda.getEndereco());
			}

		}
	}
}