/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class SaldoNegativoException extends Exception {
    public SaldoNegativoException(double saldoAtual) {
        super("Operação não permitida. Saldo atual: R$ " + String.format("%.2f", saldoAtual) + ".");
    }
}