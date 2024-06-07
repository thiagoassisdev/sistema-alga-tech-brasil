package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Colheita;
import br.com.fiap.dao.ColheitaDAO;

public class ColheitaBO {

	ColheitaDAO colheitaDao;

	// Selecionar
	public ArrayList<Colheita> selecionarBo() throws ClassNotFoundException, SQLException {
		colheitaDao = new ColheitaDAO();

		// REGRA DE NEGOCIOS

		return (ArrayList<Colheita>) colheitaDao.selecionar();
	}

	// Inserir
	public void inserirBo(Colheita colheita) throws ClassNotFoundException, SQLException {
		ColheitaDAO colheitaDAO = new ColheitaDAO();

		// REGRA DE NEGOCIOS

		colheitaDAO.inserir(colheita);
	}

	// Atualizar
	public void atualizarBo(Colheita colheita) throws ClassNotFoundException, SQLException {
		ColheitaDAO colheitaDAO = new ColheitaDAO();

		// REGRA DE NEGOCIOS

		colheitaDAO.atualizar(colheita);
	}

	// Deletar
	public void deletarBo(int idColheita) throws ClassNotFoundException, SQLException {
		ColheitaDAO colheitaDAO = new ColheitaDAO();

		// REGRA DE NEGOCIOS

		colheitaDAO.deletar(idColheita);
	}
}