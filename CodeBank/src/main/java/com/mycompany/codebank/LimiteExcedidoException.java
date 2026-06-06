/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class LimiteExcedidoException extends Exception {
    public LimiteExcedidoException(double saldoAtual, double limiteDisponivel, double valorSolicitado) {
        super("Limite excedido. Saldo: R$ " + String.format("%.2f", saldoAtual) +
              ". Limite: R$ " + String.format("%.2f", limiteDisponivel) +
              ". Valor solicitado: R$ " + String.format("%.2f", valorSolicitado) + ".");
    }
}
