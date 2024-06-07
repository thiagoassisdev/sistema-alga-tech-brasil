package br.com.fiap.main;

import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Qualidade;
import br.com.fiap.dao.QualidadeDAO;

public class TesteCadastrarQualidade {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    static float real(String j) {
        return Float.parseFloat(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
        Qualidade objQualidade = new Qualidade();
        QualidadeDAO dao = new QualidadeDAO();

        objQualidade.setIdFazenda(inteiro("Insira o ID da Fazenda"));
        objQualidade.setData(Date.valueOf(texto("Data (yyyy-mm-dd)")));
        objQualidade.setPh(real("Digite o valor do pH"));
        objQualidade.setSalinidade(real("Digite o valor da Salinidade"));
        objQualidade.setTemperatura(real("Digite a Temperatura"));
        objQualidade.setNutrientes(real("Digite o valor dos Nutrientes"));

        System.out.println(dao.inserir(objQualidade));
    }
}