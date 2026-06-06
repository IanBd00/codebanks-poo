/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class ValorInvalidoException extends Exception {
    public ValorInvalidoException(double valor) {
        super("Valor inválido: R$ " + String.format("%.2f", valor) + ". O valor deve ser maior que zero.");
    }
}
