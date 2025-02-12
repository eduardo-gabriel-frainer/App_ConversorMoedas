package com.example.conversor_moeda.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.example.conversor_moeda.Services.ApiServices;

@Controller

public class ConversorMoedaController {

    @Autowired
    private ApiServices apiServices;

    @GetMapping("/conversor")
    public String home() {
        return "index.html"; // Nome do seu arquivo HTML em templates (sem a extensão .html)
    }

    public void ConversaoController(ApiServices apiServices) {
        this.apiServices = apiServices;
    }

    @GetMapping("/conversao")
    public ResponseEntity<String> obterValorMoeda(@RequestParam String moedaBase, @RequestParam String moedaAlvo,
            @RequestParam String moedaValor) {
        // Chama o serviço para obter a conversão
        String resultado = apiServices.getConversao(moedaBase, moedaAlvo, moedaValor);
        return ResponseEntity.ok(resultado); // Retorna o resultado da conversão
    }

    @GetMapping
    public String converterMoeda(@RequestParam String moedaBase, @RequestParam String moedaAlvo,
            @RequestParam String moedaValor) {
        return apiServices.getConversao(moedaBase, moedaAlvo, moedaValor);
    }

}
