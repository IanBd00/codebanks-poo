/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class ContaCorrente extends Conta implements Tributavel {
    private double limite;

    public ContaCorrente(int numero, Cliente titular, double saldoInicial, double limite) {
        super(numero, titular, saldoInicial);
        this.limite = limite;
    }

    @Override
    protected void validarDebito(double valor) throws ValorInvalidoException, LimiteExcedidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException(valor);
        }
        if (valor > saldo + limite) {
            throw new LimiteExcedidoException(saldo, limite, valor);
        }
    }

    @Override
    public void debitar(double valor) throws ValorInvalidoException, LimiteExcedidoException {
        try {
            validarDebito(valor);
            saldo -= valor;
            getExtrato().adicionarRegistro("Débito", valor, saldo);
        } catch (ValorInvalidoException | LimiteExcedidoException e) {
            System.out.println("Erro: " + e.getMessage());
            throw e;
        } finally {
            System.out.println("Saldo atual da conta " + getNumero() + ": R$ " + String.format("%.2f", saldo));
        }
    }

    @Override
    public double calcularTarifa() {
        return TARIFA;
    }

    @Override
    public void cobrarTarifa() {
        try {
            double tarifa = calcularTarifa();
            saldo -= tarifa;
            getExtrato().adicionarRegistro("Cobrança de tarifa mensal", tarifa, saldo);
        } catch (Exception e) {
            System.out.println("Erro ao cobrar tarifa: " + e.getMessage());
        } finally {
            System.out.println("Saldo atual da conta " + getNumero() + ": R$ " + String.format("%.2f", saldo));
        }
    }
}