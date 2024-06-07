package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Medicao;
import br.com.fiap.dao.MedicaoDAO;

public class MedicaoBO {

	MedicaoDAO medicaoDao;

	// Selecionar
	public ArrayList<Medicao> selecionarBo() throws ClassNotFoundException, SQLException {
		medicaoDao = new MedicaoDAO();

		// REGRA DE NEGOCIOS

		return (ArrayList<Medicao>) medicaoDao.selecionar();
	}

	// Inserir
	public void inserirBo(Medicao medicao) throws ClassNotFoundException, SQLException {
		MedicaoDAO medicaoDAO = new MedicaoDAO();

		// REGRA DE NEGOCIOS

		medicaoDAO.inserir(medicao);
	}

	// Atualizar
	public void atualizarBo(Medicao medicao) throws ClassNotFoundException, SQLException {
		MedicaoDAO medicaoDAO = new MedicaoDAO();

		// REGRA DE NEGOCIOS

		medicaoDAO.atualizar(medicao);
	}

	// Deletar
	public void deletarBo(int idMedicao) throws ClassNotFoundException, SQLException {
		MedicaoDAO medicaoDAO = new MedicaoDAO();

		// REGRA DE NEGOCIOS

		medicaoDAO.deletar(idMedicao);
	}
}