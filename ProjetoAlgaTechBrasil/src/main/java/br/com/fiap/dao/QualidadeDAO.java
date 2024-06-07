package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Qualidade;
import br.com.fiap.conexoes.ConexaoFactory;

public class QualidadeDAO {

	public Connection minhaConexao;

	public QualidadeDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	// Select
	public List<Qualidade> selecionar() throws SQLException {
	    List<Qualidade> listaQualidade = new ArrayList<Qualidade>();
	    PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM QUALIDADE");

	    ResultSet rs = stmt.executeQuery();

	    while (rs.next()) {
	        Qualidade qualidade = new Qualidade();
	        qualidade.setIdQualidade(rs.getInt("ID_QUALIDADE"));
	        qualidade.setIdFazenda(rs.getInt("ID_FAZENDA"));
	        

	        // Tente recuperar a data como Date diretamente
	        try {
	            Date data = rs.getDate("DATA");
	            qualidade.setData(data);
	        } catch (SQLException e) {
	            // Se falhar, tente recuperar como String e converter
	            String dataString = rs.getString("DATA");
	            Date data = Date.valueOf(dataString);
	            qualidade.setData(data);
	        }

	        qualidade.setPh(rs.getFloat("PH"));
	        qualidade.setSalinidade(rs.getFloat("SALINIDADE"));
	        qualidade.setTemperatura(rs.getFloat("TEMPERATURA"));
	        qualidade.setNutrientes(rs.getFloat("NUTRIENTES"));

	        listaQualidade.add(qualidade);
	    }
	    rs.close();
	    stmt.close();
	    return listaQualidade;
	}
	

	// Insert
	public String inserir(Qualidade qualidade) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"INSERT INTO QUALIDADE (ID_FAZENDA, DATA, PH, SALINIDADE, TEMPERATURA, NUTRIENTES) VALUES (?, ?, ?, ?, ?, ?)");
		stmt.setInt(1, qualidade.getIdFazenda());
		stmt.setDate(2, qualidade.getData());
		stmt.setFloat(3, qualidade.getPh());
		stmt.setFloat(4, qualidade.getSalinidade());
		stmt.setFloat(5, qualidade.getTemperatura());
		stmt.setFloat(6, qualidade.getNutrientes());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}


	// Update
	public String atualizar(Qualidade qualidade) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"UPDATE QUALIDADE SET DATA = ?, PH = ?, SALINIDADE = ?, TEMPERATURA = ?, NUTRIENTES = ? WHERE ID_QUALIDADE = ?");
		stmt.setDate(1, qualidade.getData());
		stmt.setFloat(2, qualidade.getPh());
		stmt.setFloat(3, qualidade.getSalinidade());
		stmt.setFloat(4, qualidade.getTemperatura());
		stmt.setFloat(5, qualidade.getNutrientes());
		stmt.setInt(6, qualidade.getIdQualidade());
		stmt.executeUpdate();
		stmt.close();
		return "Atualizado com Sucesso!";
	}
	
	
	// Delete
	public String deletar(int idQualidade) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM QUALIDADE WHERE ID_QUALIDADE = ?");
		stmt.setInt(1, idQualidade);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}


}