package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Sensor;
import br.com.fiap.conexoes.ConexaoFactory;

public class SensorDAO {

    public Connection minhaConexao;

    public SensorDAO() throws ClassNotFoundException, SQLException {
        super();
        this.minhaConexao = new ConexaoFactory().conexao();
    }
    
    // Select
    public List<Sensor> selecionar() throws SQLException {
        List<Sensor> listaSensor = new ArrayList<Sensor>();
        PreparedStatement stmt = minhaConexao.prepareStatement("SELECT * FROM SENSOR");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Sensor sensor = new Sensor();
            sensor.setIdSensor(rs.getInt("ID_SENSOR"));
            sensor.setTipo(rs.getString("TIPO"));
            sensor.setUnidade(rs.getString("UNIDADE"));
            listaSensor.add(sensor);
        }
        rs.close();
        stmt.close();
        return listaSensor;
    }
    

    // Insert
    public String inserir(Sensor sensor) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement("INSERT INTO SENSOR (TIPO, UNIDADE) VALUES (?, ?)");
        stmt.setString(1, sensor.getTipo());
        stmt.setString(2, sensor.getUnidade());
        stmt.execute();
        stmt.close();
        return "Cadastrado com Sucesso!";
    }


    // Update
    public String atualizar(Sensor sensor) throws SQLException {
        PreparedStatement stmt = minhaConexao.prepareStatement(
        		"UPDATE SENSOR SET TIPO = ?, UNIDADE = ? WHERE ID_SENSOR = ?");
        stmt.setString(1, sensor.getTipo());
        stmt.setString(2, sensor.getUnidade());
        stmt.setInt(3, sensor.getIdSensor());
        stmt.executeUpdate();
        stmt.close();
        return "Atualizado com Sucesso!";
    }
    
    
    // Delete
    public String deletar(int idSensor) throws SQLException {
        String sql = "DELETE FROM SENSOR WHERE ID_SENSOR = ?";
        PreparedStatement stmt = minhaConexao.prepareStatement(sql);
        stmt.setInt(1, idSensor);
        int rowsDeleted = stmt.executeUpdate();
        stmt.close();
        return rowsDeleted > 0 ? "Sensor deletada com sucesso!" : "Nenhum Sensor encontrado com o ID fornecido";
    }


}