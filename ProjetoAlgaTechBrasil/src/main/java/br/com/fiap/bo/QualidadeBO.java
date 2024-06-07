package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Qualidade;
import br.com.fiap.dao.QualidadeDAO;

public class QualidadeBO {
	
	QualidadeDAO qualidadeDao;
	
	// Selecionar 
	public ArrayList<Qualidade> selecionarBo() throws ClassNotFoundException, SQLException{
		qualidadeDao = new QualidadeDAO();
		
		// REGRA DE NEGOCIOS
		
		return (ArrayList<Qualidade>) qualidadeDao.selecionar();
	}
	
	// Inserir 
	public void inserirBo(Qualidade qualidade) throws ClassNotFoundException, SQLException {
		QualidadeDAO qualidadeDAO = new QualidadeDAO();
		
		// REGRA DE NEGOCIOS
		
		qualidadeDAO.inserir(qualidade);
	}
	
	// Atualizar 
	public void atualizarBo(Qualidade qualidade) throws ClassNotFoundException, SQLException {
		QualidadeDAO qualidadeDAO = new QualidadeDAO();
		
		// REGRA DE NEGOCIOS
		
		qualidadeDAO.atualizar(qualidade);
	}
	
	// Deletar
	public void deletarBo (int idQualidade) throws ClassNotFoundException, SQLException {
		QualidadeDAO qualidadeDAO = new QualidadeDAO();
		
		// REGRA DE NEGOCIOS
		
		qualidadeDAO.deletar(idQualidade);		
	}
}
