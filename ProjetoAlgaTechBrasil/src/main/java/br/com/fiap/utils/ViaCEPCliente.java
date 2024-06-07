package br.com.fiap.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;

public class ViaCEPCliente {
    public static String buscarEnderecoPorCEP(String cep) throws Exception {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();

        JSONObject json = new JSONObject(content.toString());
        if (json.has("erro")) {
            throw new Exception("CEP não encontrado");
        }

        String endereco = json.getString("logradouro") + ", " + json.getString("bairro") + ", " + json.getString("localidade") + " - " + json.getString("uf");
        return endereco;
    }
}