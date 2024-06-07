package br.com.fiap.main;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

import br.com.fiap.beans.Medicao;
import br.com.fiap.dao.MedicaoDAO;

public class TesteCadastrarMedicao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            MedicaoDAO medicaoDAO = new MedicaoDAO();
            Medicao medicao = new Medicao();

            System.out.println("Digite o ID do sensor:");
            medicao.setIdSensor(scanner.nextInt());

            System.out.println("Digite o ID da fazenda:");
            int idFazenda = scanner.nextInt();
            medicao.setIdFazenda(idFazenda);

            System.out.println("Digite o valor da medição:");
            medicao.setValor(scanner.nextFloat());

            System.out.println("Digite a data e hora da medição (yyyy-MM-dd HH:mm:ss):");
            scanner.nextLine(); // Consumir a nova linha
            String dataHoraStr = scanner.nextLine();

            // Validar e converter a data e hora
            Timestamp dataHora = validarEConverterDataHora(dataHoraStr);
            if (dataHora == null) {
                System.out.println("Formato de data e hora inválido!");
                scanner.close();
                return;
            }
            medicao.setDataHora(dataHora);


            // Solicitar ao usuário que informe o clima manualmente
            System.out.println("Digite o clima atual:");
            String clima = scanner.nextLine();
            medicao.setClima(clima);

            String resultado = medicaoDAO.inserir(medicao);
            System.out.println(resultado);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }

    private static Timestamp validarEConverterDataHora(String dataHoraStr) {
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            dateFormat.setLenient(false);
            return new Timestamp(dateFormat.parse(dataHoraStr).getTime());
        } catch (ParseException e) {
            return null;
        }
    }
}