package com.example.conversor_moeda.ComunicationUser;

import java.util.Scanner;

public class PedirMoedasUsuario {

    public String[] getMoedasUsuario() {

        Scanner input = new Scanner(System.in);

        System.out.println("Qual vai ser a Moeda Base? (sigla 3 caracteres)");
        String moedaBase = input.nextLine();

        System.out.println("Qual vai ser a Moeda Alvo? (sigla 3 caracteres)");
        String moedaAlvo = input.nextLine();

        return new String[] { moedaBase, moedaAlvo };
    }
}
