package com.example.conversor_moeda.Services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class ApiServices {

    public String getConversao(String moedaBase, String moedaAlvo, String moedaValor) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v6.exchangerate-api.com/v6/c865bf2bbd27129633cc48a5/latest/" + moedaBase))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JSONObject jsonResponse = new JSONObject(response.body());

            double taxa = jsonResponse.getJSONObject("conversion_rates").getDouble(moedaAlvo);
            double valor = Double.parseDouble(moedaValor); // Converte para número
            double valorConvertido = valor * taxa; // Calcula o valor convertido

            // return "<span class='texto-pequeno'>1 " + moedaBase
            // + " hoje equivale a</span><br><span class='texto-grande'>" + taxa + " " +
            // moedaAlvo + "</span>";

            return "<span class='texto-pequeno'>" + valor + " " + moedaBase + " equivale a</span><br>" +
                    "<span class='texto-grande'>" + valorConvertido + " " + moedaAlvo + "</span>";

        } catch (IOException | InterruptedException e) {
            return "Erro ao buscar os dados da API.";
        }
    }
}
