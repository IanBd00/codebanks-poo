/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class Banco {
    private Cliente[][] agencias;
    private int[] totalClientesPorAgencia;

    public Banco() {
        this.agencias = new Cliente[3][10];
        this.totalClientesPorAgencia = new int[3];
    }

    public void adicionarCliente(int agencia, Cliente cliente) {
        if (agencia >= 0 && agencia < 3 && totalClientesPorAgencia[agencia] < 10) {
            agencias[agencia][totalClientesPorAgencia[agencia]] = cliente;
            totalClientesPorAgencia[agencia]++;
        }
    }

    public void exibirClientesPorAgencia(int agencia) {
        System.out.println("=== Clientes da Agência " + (agencia + 1) + " ===");
        for (int i = 0; i < totalClientesPorAgencia[agencia]; i++) {
            Cliente c = agencias[agencia][i];
            System.out.println("Nome: " + c.getNome() +
                               " | CPF: " + c.getCpf() +
                               " | Total de contas: " + c.getTotalContas());
        }
    }

    public void exibirRelatorioGeral() {
        System.out.println("=== Relatório Geral do Banco ===");
        double saldoTotalBanco = 0;
        for (int i = 0; i < agencias.length; i++) {
            System.out.println("Agência " + (i + 1) + ": " + totalClientesPorAgencia[i] + " cliente(s)");
            for (int j = 0; j < totalClientesPorAgencia[i]; j++) {
                Cliente c = agencias[i][j];
                for (int k = 0; k < c.getTotalContas(); k++) {
                    if (c.getContas()[k] != null) {
                        saldoTotalBanco += c.getContas()[k].getSaldo();
                    }
                }
            }
        }
        System.out.println("Saldo total consolidado do banco: R$ " + String.format("%.2f", saldoTotalBanco));
    }
}
