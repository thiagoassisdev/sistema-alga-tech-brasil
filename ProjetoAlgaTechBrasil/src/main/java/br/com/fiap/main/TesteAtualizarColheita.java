package br.com.fiap.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Colheita;
import br.com.fiap.dao.ColheitaDAO;

public class TesteAtualizarColheita {

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
        Colheita objColheita = new Colheita();
        ColheitaDAO dao = new ColheitaDAO();

        // Listar todas as colheitas
        List<Colheita> listaColheita = dao.selecionar();
        System.out.println("Lista de Colheitas:");
        for (Colheita colheita : listaColheita) {
            System.out.println("ID Colheita: " + colheita.getIdColheita() + " - ID Fazenda: " + colheita.getIdFazenda() +
                    " - Data: " + colheita.getData() + " - Quantidade: " + colheita.getQuantidade());
        }

        // Solicitar ao usuário o ID da colheita a ser atualizada
        int idColheita = inteiro("Digite o ID da colheita que deseja atualizar: ");

        // Verificar se a colheita existe
        boolean colheitaEncontrada = false;
        for (Colheita colheita : listaColheita) {
            if (colheita.getIdColheita() == idColheita) {
                colheitaEncontrada = true;
                break;
            }
        }

        if (colheitaEncontrada) {
            // Solicitar os novos dados da colheita
            objColheita.setIdColheita(idColheita);
            objColheita.setData(Date.valueOf(texto("Informe a nova data, no formato: (yyyy-mm-dd): ")));
            objColheita.setQuantidade(real("Informe a nova quantidade: "));

            // Atualizar a colheita
            System.out.println(dao.atualizar(objColheita));
        } else {
            System.out.println("Colheita não encontrada com o ID fornecido.");
        }
    }
}