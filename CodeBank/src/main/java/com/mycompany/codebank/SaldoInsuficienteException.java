/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class SaldoInsuficienteException extends Exception {
    public SaldoInsuficienteException(double saldoDisponivel, double valorSolicitado) {
        super("Saldo insuficiente. Saldo disponível: R$ " + String.format("%.2f", saldoDisponivel) +
              ". Valor solicitado: R$ " + String.format("%.2f", valorSolicitado) + ".");
    }
}
