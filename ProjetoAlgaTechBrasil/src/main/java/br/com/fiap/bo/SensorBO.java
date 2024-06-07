package br.com.fiap.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.beans.Sensor;
import br.com.fiap.dao.SensorDAO;

public class SensorBO {

	SensorDAO sensorDao;

	// Selecionar
	public ArrayList<Sensor> selecionarBo() throws ClassNotFoundException, SQLException {
		sensorDao = new SensorDAO();

		// REGRA DE NEGOCIOS

		return (ArrayList<Sensor>) sensorDao.selecionar();
	}

	// Inserir
	public void inserirBo(Sensor sensor) throws ClassNotFoundException, SQLException {
		SensorDAO sensorDAO = new SensorDAO();

		// REGRA DE NEGOCIOS

		sensorDAO.inserir(sensor);
	}

	// Atualizar
	public void atualizarBo(Sensor sensor) throws ClassNotFoundException, SQLException {
		SensorDAO sensorDAO = new SensorDAO();

		// REGRA DE NEGOCIOS

		sensorDAO.atualizar(sensor);
	}

	// Deletar
	public void deletarBo(int idSensor) throws ClassNotFoundException, SQLException {
		SensorDAO sensorDAO = new SensorDAO();

		// REGRA DE NEGOCIOS

		sensorDAO.deletar(idSensor);
	}
}