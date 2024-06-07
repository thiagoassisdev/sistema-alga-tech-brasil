package br.com.fiap.main;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Fazenda;
import br.com.fiap.dao.FazendaDAO;
import br.com.fiap.utils.ViaCEPCliente;

public class TesteAtualizarFazenda {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
        Fazenda objFazenda = new Fazenda();
        FazendaDAO dao = new FazendaDAO();

        // Listar todas as fazendas
        List<Fazenda> listaFazenda = dao.selecionar();
        System.out.println("Lista de Fazendas:");
        for (Fazenda fazenda : listaFazenda) {
            System.out.println(fazenda.getIdFazenda() + " " + fazenda.getNome() + " " + fazenda.getLocalizacao() + " " + fazenda.getCep() + " " + fazenda.getEndereco());
        }

        // Solicitar ao usuário o ID da fazenda a ser atualizada
        int idFazenda = inteiro("Digite o ID da fazenda que deseja atualizar: ");

        // Verificar se a fazenda existe
        boolean fazendaEncontrada = false;
        for (Fazenda fazenda : listaFazenda) {
            if (fazenda.getIdFazenda() == idFazenda) {
                fazendaEncontrada = true;
                break;
            }
        }

        if (fazendaEncontrada) {
            // Solicitar os novos dados da fazenda
            objFazenda.setIdFazenda(idFazenda);
            objFazenda.setNome(texto("Digite o novo nome da fazenda:"));
            objFazenda.setLocalizacao(texto("Digite a nova localização da fazenda:"));
            String cep = texto("Digite o novo CEP da fazenda:");
            objFazenda.setCep(cep);

            // Consultar API ViaCEP
            try {
                String endereco = ViaCEPCliente.buscarEnderecoPorCEP(cep);
                objFazenda.setEndereco(endereco);
                System.out.println("Endereço encontrado: " + endereco);
            } catch (Exception e) {
                System.out.println("Erro ao buscar endereço: " + e.getMessage());
                return;
            }

            // Atualizar a fazenda
            System.out.println(dao.atualizar(objFazenda));
        } else {
            System.out.println("Fazenda não encontrada com o ID fornecido.");
        }
    }
}