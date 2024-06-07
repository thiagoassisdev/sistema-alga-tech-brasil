package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Qualidade;
import br.com.fiap.dao.QualidadeDAO;

public class TesteAtualizarQualidade {

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

        // Listar todas as qualidades
        List<Qualidade> listaQualidade = dao.selecionar();
        System.out.println("Lista de Qualidade:");
        for (Qualidade qualidade : listaQualidade) {
            System.out.println(qualidade.getIdQualidade() + " " + qualidade.getIdFazenda() + " " + qualidade.getData() + " " + qualidade.getPh() + " "
                    + qualidade.getSalinidade() + " " + qualidade.getTemperatura() + " "
                    + qualidade.getNutrientes());
        }

        // Solicitar ao usuário o ID da qualidade a ser atualizada
        int idQualidade = inteiro("Digite o ID da qualidade que deseja atualizar: ");

        // Verificar se a qualidade existe
        boolean qualidadeEncontrada = false;
        for (Qualidade qualidade : listaQualidade) {
            if (qualidade.getIdQualidade() == idQualidade) {
                qualidadeEncontrada = true;
                break;
            }
        }

        if (qualidadeEncontrada) {
            // Solicitar os novos dados da qualidade
            objQualidade.setIdQualidade(idQualidade); 
            objQualidade.setData(Date.valueOf(texto("Digite a nova data no formato(yyyy-mm-dd):")));
            objQualidade.setPh(real("Digite o novo valor do pH: "));
            objQualidade.setSalinidade(real("Digite o novo valor da Salinidade: "));
            objQualidade.setTemperatura(real("Digite a nova Temperatura: "));
            objQualidade.setNutrientes(real("Digite o novo valor dos Nutrientes: "));

            // Atualizar a qualidade
            System.out.println(dao.atualizar(objQualidade));
        } else {
            System.out.println("Qualidade não encontrada com o ID fornecido.");
        }
    }
}