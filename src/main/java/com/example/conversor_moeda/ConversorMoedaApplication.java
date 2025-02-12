package com.example.conversor_moeda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.conversor_moeda.ComunicationUser.PedirMoedasUsuario;
import com.example.conversor_moeda.Services.ApiServices;

@SpringBootApplication
public class ConversorMoedaApplication {

	public static void main(String[] args) {

		SpringApplication.run(com.example.conversor_moeda.ConversorMoedaApplication.class, args);

		// PedirMoedasUsuario pedir = new PedirMoedasUsuario();
		// String[] moedas = pedir.getMoedasUsuario();

		// ApiServices api = new ApiServices();
		// api.getConversao(moedas[0], moedas[1]);
	}
}
