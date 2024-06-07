package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Colheita;
import br.com.fiap.conexoes.ConexaoFactory;

public class ColheitaDAO {

	public Connection minhaConexao;

	public ColheitaDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}
	
	 
	// Select
    public List<Colheita> selecionar() throws SQLException {
        List<Colheita> listaColheita = new ArrayList<Colheita>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM COLHEITA");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Colheita colheita = new Colheita();
            colheita.setIdColheita(rs.getInt("ID_COLHEITA"));
            colheita.setIdFazenda(rs.getInt("ID_FAZENDA"));
            
            // Tente recuperar a data como Date diretamente
            try {
                Date data = rs.getDate("DATA");
                colheita.setData(data);
            } catch (SQLException e) {
                // Se falhar, tente recuperar como String e converter
                String dataString = rs.getString("DATA");
                Date data = Date.valueOf(dataString);
                colheita.setData(data);
            }
            
            colheita.setQuantidade(rs.getFloat("QUANTIDADE"));
            listaColheita.add(colheita);
        }
        rs.close();
        stmt.close();
        return listaColheita;
    }
	
    
	// Insert
	public String inserir(Colheita colheita) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("INSERT INTO COLHEITA (ID_FAZENDA, DATA, QUANTIDADE) VALUES (?, ?, ?)");
		stmt.setInt(1, colheita.getIdFazenda());
		stmt.setDate(2, colheita.getData());
		stmt.setFloat(3, colheita.getQuantidade());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}


	// Update
    public String atualizar(Colheita colheita) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("UPDATE COLHEITA SET DATA = ?, QUANTIDADE = ? WHERE ID_COLHEITA = ?");
        stmt.setDate(1, colheita.getData());
        stmt.setFloat(2, colheita.getQuantidade());
        stmt.setInt(3, colheita.getIdColheita());
        stmt.executeUpdate();
        stmt.close();
        return "Atualizado com Sucesso!";
    }
    
    // Delete
    public String deletar(int idColheita) throws SQLException {
        String sql = "DELETE FROM COLHEITA WHERE ID_COLHEITA = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setInt(1, idColheita);
        int rowsDeleted = stmt.executeUpdate();
        stmt.close();
        return rowsDeleted > 0 ? "Colheita deletada com sucesso!" : "Nenhuma colheita encontrada com o ID fornecido";
    }

}