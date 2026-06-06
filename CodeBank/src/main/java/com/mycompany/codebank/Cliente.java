/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class Cliente {
    private String nome;
    private String cpf;
    private Conta[] contas;
    private int totalContas;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
        this.contas = new Conta[5];
        this.totalContas = 0;
    }

    public void adicionarConta(Conta conta) {
        if (totalContas < 5) {
            contas[totalContas] = conta;
            totalContas++;
        }
    }

    public void removerConta(int indice) {
        if (indice >= 0 && indice < totalContas) {
            contas[indice] = null;
            for (int i = indice; i < totalContas - 1; i++) {
                contas[i] = contas[i + 1];
            }
            contas[totalContas - 1] = null;
            totalContas--;
        }
    }

    public Conta[] getContas() {
        return contas;
    }

    public int getTotalContas() {
        return totalContas;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
