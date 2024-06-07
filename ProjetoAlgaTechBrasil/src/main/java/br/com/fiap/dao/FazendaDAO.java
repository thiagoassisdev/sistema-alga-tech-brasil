package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Fazenda;
import br.com.fiap.conexoes.ConexaoFactory;

public class FazendaDAO {

	public Connection minhaConexao;

	public FazendaDAO() throws ClassNotFoundException, SQLException {
		super();
		this.minhaConexao = new ConexaoFactory().conexao();
	}

	// Select
	public List<Fazenda> selecionar() throws SQLException {
		List<Fazenda> listaFazenda = new ArrayList<Fazenda>();
		PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM FAZENDA");

		ResultSet rs = stmt.executeQuery();

		while (rs.next()) {
			Fazenda fazenda = new Fazenda();
			fazenda.setIdFazenda(rs.getInt("ID_FAZENDA"));
			fazenda.setNome(rs.getString("NOME"));
			fazenda.setLocalizacao(rs.getString("LOCALIZACAO"));
			fazenda.setCep(rs.getString("CEP"));
			fazenda.setEndereco(rs.getString("ENDERECO"));

			listaFazenda.add(fazenda);
		}
		rs.close();
		stmt.close();
		return listaFazenda;
	}

	// Insert
	public String inserir(Fazenda fazenda) throws SQLException {
		PreparedStatement stmt = minhaConexao
				.prepareStatement("INSERT INTO FAZENDA (NOME, LOCALIZACAO, CEP, ENDERECO) VALUES (?, ?, ?, ?)");
		stmt.setString(1, fazenda.getNome());
		stmt.setString(2, fazenda.getLocalizacao());
		stmt.setString(3, fazenda.getCep());
		stmt.setString(4, fazenda.getEndereco());
		stmt.execute();
		stmt.close();
		return "Cadastrado com Sucesso!";
	}

	// Update
	public String atualizar(Fazenda fazenda) throws SQLException, ClassNotFoundException {
		PreparedStatement stmt = minhaConexao.prepareStatement(
				"UPDATE fazenda SET nome = ?, localizacao = ?, cep = ?, endereco = ? WHERE id_fazenda = ?");
		stmt.setString(1, fazenda.getNome());
		stmt.setString(2, fazenda.getLocalizacao());
		stmt.setString(3, fazenda.getCep());
		stmt.setString(4, fazenda.getEndereco());
		stmt.setInt(5, fazenda.getIdFazenda());

		int rowsUpdated = stmt.executeUpdate();
		stmt.close();

		if (rowsUpdated > 0) {
			return "Fazenda atualizada com sucesso!";
		} else {
			return "Erro ao atualizar fazenda.";
		}
	}

	// Delete
	public String deletar(int idFazenda) throws SQLException {
		PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM FAZENDA WHERE ID_FAZENDA = ?");
		stmt.setInt(1, idFazenda);
		stmt.execute();
		stmt.close();
		return "Deletado com Sucesso!";
	}

}