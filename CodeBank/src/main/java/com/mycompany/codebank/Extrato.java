/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class Extrato {
    private String[] registros;
    private int totalRegistros;

    public Extrato() {
        this.registros = new String[50];
        this.totalRegistros = 0;
    }

    public void adicionarRegistro(String descricao, double valor, double saldoResultante) {
        if (totalRegistros < 50) {
            registros[totalRegistros] = descricao +
                " | Valor: R$ " + String.format("%.2f", valor) +
                " | Saldo: R$ " + String.format("%.2f", saldoResultante);
            totalRegistros++;
        }
    }

    public void exibirExtrato() {
        for (int i = 0; i < totalRegistros; i++) {
            System.out.println((i + 1) + ". " + registros[i]);
        }
    }
}