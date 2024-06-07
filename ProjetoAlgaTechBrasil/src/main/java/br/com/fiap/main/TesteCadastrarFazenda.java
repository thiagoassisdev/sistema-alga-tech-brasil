package br.com.fiap.main;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Fazenda;
import br.com.fiap.dao.FazendaDAO;
import br.com.fiap.utils.ViaCEPCliente;

public class TesteCadastrarFazenda {

    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // Instanciar objetos
        Fazenda objFazenda = new Fazenda();
        FazendaDAO dao = new FazendaDAO();

        objFazenda.setNome(texto("Digite o nome da fazenda"));
        objFazenda.setLocalizacao(texto("Digite a localização da fazenda"));
        String cep = texto("Digite o CEP da fazenda");
        objFazenda.setCep(cep);

        // Consultar API ViaCEP
        try {
            String endereco = ViaCEPCliente.buscarEnderecoPorCEP(cep);
            objFazenda.setEndereco(endereco);
            JOptionPane.showMessageDialog(null, "Endereço encontrado: " + endereco);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar endereço: " + e.getMessage());
            return;
        }

        try {
            String resultado = dao.inserir(objFazenda);
            JOptionPane.showMessageDialog(null, resultado);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar fazenda: " + e.getMessage());
        }
    }
}