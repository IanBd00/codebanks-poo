/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public abstract class Conta {
    private int numero;
    private Cliente titular;
    protected double saldo;
    private Extrato extrato;

    public Conta(int numero, Cliente titular, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
        this.extrato = new Extrato();
    }

    public abstract void debitar(double valor) throws ValorInvalidoException, SaldoInsuficienteException, LimiteExcedidoException;

    protected abstract void validarDebito(double valor) throws ValorInvalidoException, SaldoInsuficienteException, LimiteExcedidoException;

    public void creditar(double valor) throws ValorInvalidoException {
        try {
            if (valor <= 0) {
                throw new ValorInvalidoException(valor);
            }
            saldo += valor;
            extrato.adicionarRegistro("Crédito", valor, saldo);
        } catch (ValorInvalidoException e) {
            System.out.println("Erro: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Saldo atual da conta " + numero + ": R$ " + String.format("%.2f", saldo));
        }
    }

    public void transferir(Conta destino, double valor) throws ValorInvalidoException, SaldoInsuficienteException, LimiteExcedidoException {
        try {
            this.validarDebito(valor);
            saldo -= valor;
            destino.saldo += valor;
            extrato.adicionarRegistro("Transferência enviada para conta " + destino.getNumero(), valor, saldo);
            destino.getExtrato().adicionarRegistro("Transferência recebida da conta " + numero, valor, destino.getSaldo());
        } catch (ValorInvalidoException | SaldoInsuficienteException | LimiteExcedidoException e) {
            System.out.println("Erro na transferência: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Saldo atual da conta " + numero + ": R$ " + String.format("%.2f", saldo));
            System.out.println("Saldo atual da conta " + destino.getNumero() + ": R$ " + String.format("%.2f", destino.getSaldo()));
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public Extrato getExtrato() {
        return extrato;
    }
}
