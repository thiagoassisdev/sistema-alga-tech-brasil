package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.dao.QualidadeDAO;

public class TesteDeletarQualidade {

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
        QualidadeDAO dao = new QualidadeDAO();

        int idQualidade = inteiro("Insira o ID da Qualidade a ser deletada");

        System.out.println(dao.deletar(idQualidade));
    }
}