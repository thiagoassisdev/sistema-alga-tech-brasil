package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Sensor;
import br.com.fiap.dao.SensorDAO;

public class TesteCadastrarSensor {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
        Sensor objSensor = new Sensor();
        SensorDAO dao = new SensorDAO();

        objSensor.setTipo(texto("Tipo"));
        objSensor.setUnidade(texto("Unidade"));

        System.out.println(dao.inserir(objSensor));
    }
}