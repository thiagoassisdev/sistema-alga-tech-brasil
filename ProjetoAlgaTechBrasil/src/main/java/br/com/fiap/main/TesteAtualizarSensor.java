package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Sensor;
import br.com.fiap.dao.SensorDAO;

public class TesteAtualizarSensor {

	static String texto(String j) {
		return JOptionPane.showInputDialog(j);
	}

	static int inteiro(String j) {
		return Integer.parseInt(JOptionPane.showInputDialog(j));
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// Instanciar objetos
		Sensor objSensor = new Sensor();
		SensorDAO dao = new SensorDAO();

		// Listar todos os sensores
		List<Sensor> listaSensor = dao.selecionar();
		System.out.println("Lista de Sensores:");
		for (Sensor sensor : listaSensor) {
			System.out.println(sensor.getIdSensor() + " " + sensor.getTipo() + " " + sensor.getUnidade());
		}

		// Solicitar ao usuário o ID do sensor a ser atualizada
		int idSensor = inteiro("Digite o ID da colheita que deseja atualizar: ");

		
		// Verificar se o sensor existe
        boolean SensorEncontrada = false;
        for (Sensor sensor : listaSensor) {
            if (sensor.getIdSensor() == idSensor) {
                SensorEncontrada = true;
                break;
            }
        }

        if (SensorEncontrada) {
            // Solicitar os novos dados do sensor
        	objSensor.setIdSensor(idSensor);
    		objSensor.setTipo(texto("Digite o tipo do sensor a ser alterado: "));
    		objSensor.setUnidade(texto("Digite a nova unidade do sensor: "));

            // Atualizar o sensor
            System.out.println(dao.atualizar(objSensor));
        } else {
            System.out.println("Sensor não encontrado com o ID fornecido.");
        }
    }

}