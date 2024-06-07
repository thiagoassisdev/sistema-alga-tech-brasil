package br.com.fiap.main;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.beans.Sensor;
import br.com.fiap.dao.SensorDAO;

public class TesteSelecionarSensor {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
        SensorDAO dao = new SensorDAO();

        List<Sensor> listaSensor = (ArrayList<Sensor>) dao.selecionar();

        if (listaSensor != null) {
            // foreach
            for (Sensor sensor : listaSensor) {
                System.out.println(sensor.getIdSensor() + " " + sensor.getTipo() + " " + sensor.getUnidade());
            }
        }
    }
}