package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Medicao;
import br.com.fiap.conexoes.ConexaoFactory;

public class MedicaoDAO {

    public Connection minhaConexao;

    public MedicaoDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }
    
    
    // Select
    public List<Medicao> selecionar() throws SQLException {
        List<Medicao> listaMedicao = new ArrayList<Medicao>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM MEDICAO");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Medicao medicao = new Medicao();
            medicao.setIdMedicao(rs.getInt("ID_MEDICAO"));
            medicao.setIdSensor(rs.getInt("ID_SENSOR"));
            medicao.setIdFazenda(rs.getInt("ID_FAZENDA"));
            medicao.setValor(rs.getFloat("VALOR"));
            medicao.setDataHora(rs.getTimestamp("DATA_HORA"));
            medicao.setClima(rs.getString("CLIMA"));
            listaMedicao.add(medicao);
        }
        return listaMedicao;
    }
    

    // Insert
    public String inserir(Medicao medicao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "INSERT INTO MEDICAO (ID_SENSOR, ID_FAZENDA, VALOR, DATA_HORA, CLIMA) VALUES (?, ?, ?, ?, ?)");
        stmt.setInt(1, medicao.getIdSensor());
        stmt.setInt(2, medicao.getIdFazenda());
        stmt.setFloat(3, medicao.getValor());
        stmt.setTimestamp(4, medicao.getDataHora());
        stmt.setString(5, medicao.getClima());
        stmt.execute();
        stmt.close();
        return "Cadastrado com Sucesso!";
    }
    

    // Update
    public String atualizar(Medicao medicao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
                "UPDATE MEDICAO SET ID_FAZENDA = ?, VALOR = ?, DATA_HORA = ?, CLIMA = ? WHERE ID_SENSOR = ?");
        stmt.setInt(1, medicao.getIdFazenda());
        stmt.setFloat(2, medicao.getValor());
        stmt.setTimestamp(3, medicao.getDataHora());
        stmt.setString(4, medicao.getClima());
        stmt.setInt(5, medicao.getIdSensor());
        stmt.executeUpdate();
        stmt.close();
        return "Atualizado com Sucesso!";
    }
    
    // Delete
    public String deletar(int idMedicao) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("DELETE FROM MEDICAO WHERE ID_MEDICAO = ?");
        stmt.setInt(1, idMedicao);
        stmt.execute();
        stmt.close();
        return "Deletado com Sucesso!";
    }

}