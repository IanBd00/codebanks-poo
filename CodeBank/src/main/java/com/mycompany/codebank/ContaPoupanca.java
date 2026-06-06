/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class ContaPoupanca extends Conta {
    private double taxaRendimento;

    public ContaPoupanca(int numero, Cliente titular, double saldoInicial, double taxaRendimento) {
        super(numero, titular, saldoInicial);
        this.taxaRendimento = taxaRendimento;
    }

    @Override
    protected void validarDebito(double valor) throws ValorInvalidoException, SaldoInsuficienteException {
        if (valor <= 0) {
            throw new ValorInvalidoException(valor);
        }
        if (valor > saldo) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
    }

    @Override
    public void debitar(double valor) throws ValorInvalidoException, SaldoInsuficienteException {
        try {
            validarDebito(valor);
            saldo -= valor;
            getExtrato().adicionarRegistro("Débito", valor, saldo);
        } catch (ValorInvalidoException | SaldoInsuficienteException e) {
            System.out.println("Erro: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Saldo atual da conta " + getNumero() + ": R$ " + String.format("%.2f", saldo));
        }
    }

    public void aplicarRendimento() throws SaldoNegativoException {
        try {
            if (saldo <= 0) {
                throw new SaldoNegativoException(saldo);
            }
            double rendimento = saldo * taxaRendimento;
            saldo += rendimento;
            getExtrato().adicionarRegistro("Rendimento mensal", rendimento, saldo);
        } catch (SaldoNegativoException e) {
            System.out.println("Erro: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Saldo atual da conta " + getNumero() + ": R$ " + String.format("%.2f", saldo));
        }
    }
}
