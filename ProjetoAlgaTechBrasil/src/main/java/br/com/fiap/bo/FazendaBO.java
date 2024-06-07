package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Fazenda;
import br.com.fiap.dao.FazendaDAO;

public class FazendaBO {
	
	FazendaDAO fazendaDao;
	
	// Selecionar 
	public ArrayList<Fazenda> selecionarBo() throws ClassNotFoundException, SQLException{
		fazendaDao = new FazendaDAO();
		
		// REGRA DE NEGOCIOS
		
		return (ArrayList<Fazenda>) fazendaDao.selecionar();
	}
	
	// Inserir 
	public void inserirBo(Fazenda fazenda) throws ClassNotFoundException, SQLException {
		FazendaDAO fazendaDAO = new FazendaDAO();
		
		// REGRA DE NEGOCIOS
		
		fazendaDAO.inserir(fazenda);
	}
	
	// Atualizar 
	public void atualizarBo(Fazenda fazenda) throws ClassNotFoundException, SQLException {
		FazendaDAO fazendaDAO = new FazendaDAO();
		
		// REGRA DE NEGOCIOS
		
		fazendaDAO.atualizar(fazenda);
	}
	
	// Deletar
	public void deletarBo (int idFazenda) throws ClassNotFoundException, SQLException {
		FazendaDAO fazendaDAO = new FazendaDAO();
		
		// REGRA DE NEGOCIOS
		
		fazendaDAO.deletar(idFazenda);		
	}
}