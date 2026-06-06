/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.codebank;

/**
 *
 * @author ianbello
 */
public class Principal {
    public static void main(String[] args) {

        // ==================== INSTANCIAÇÃO ====================

        Banco banco = new Banco();

        // Clientes
        Cliente cliente1 = new Cliente("Ana Lima", "111.111.111-11");
        Cliente cliente2 = new Cliente("Bruno Costa", "222.222.222-22");
        Cliente cliente3 = new Cliente("Carla Souza", "333.333.333-33");
        Cliente cliente4 = new Cliente("Diego Melo", "444.444.444-44");
        Cliente cliente5 = new Cliente("Eva Rocha", "555.555.555-55");
        Cliente cliente6 = new Cliente("Felipe Dias", "666.666.666-66");

        // Contas
        ContaCorrente cc1 = new ContaCorrente(1001, cliente1, 1000.00, 500.00);
        ContaPoupanca cp1 = new ContaPoupanca(1002, cliente1, 2000.00, 0.005);

        ContaCorrente cc2 = new ContaCorrente(1003, cliente2, 500.00, 300.00);
        ContaPoupanca cp2 = new ContaPoupanca(1004, cliente2, 100.00, 0.005);

        ContaCorrente cc3 = new ContaCorrente(1005, cliente3, 750.00, 400.00);

        ContaPoupanca cp3 = new ContaPoupanca(1006, cliente4, 3000.00, 0.008);

        ContaCorrente cc4 = new ContaCorrente(1007, cliente5, 200.00, 200.00);

        ContaPoupanca cp4 = new ContaPoupanca(1008, cliente6, 0.00, 0.005);

        // Vincula contas aos clientes
        cliente1.adicionarConta(cc1);
        cliente1.adicionarConta(cp1);

        cliente2.adicionarConta(cc2);
        cliente2.adicionarConta(cp2);

        cliente3.adicionarConta(cc3);

        cliente4.adicionarConta(cp3);

        cliente5.adicionarConta(cc4);

        cliente6.adicionarConta(cp4);

        // Distribui clientes nas agências
        banco.adicionarCliente(0, cliente1);
        banco.adicionarCliente(0, cliente2);

        banco.adicionarCliente(1, cliente3);
        banco.adicionarCliente(1, cliente4);

        banco.adicionarCliente(2, cliente5);
        banco.adicionarCliente(2, cliente6);

        // ==================== OPERAÇÕES ====================

        System.out.println("---------- Operações ----------");

        // Crédito válido
        try {
            cc1.creditar(500.00);
        } catch (ValorInvalidoException e) { }

        // Crédito inválido
        try {
            cp1.creditar(-100.00);
        } catch (ValorInvalidoException e) { }

        // Débito válido na corrente
        try {
            cc1.debitar(300.00);
        } catch (ValorInvalidoException | LimiteExcedidoException e) { }

        // Débito excedendo limite na corrente
        try {
            cc2.debitar(900.00);
        } catch (ValorInvalidoException | LimiteExcedidoException e) { }

        // Débito válido na poupança
        try {
            cp1.debitar(200.00);
        } catch (ValorInvalidoException | SaldoInsuficienteException e) { }

        // Débito excedendo saldo na poupança
        try {
            cp2.debitar(500.00);
        } catch (ValorInvalidoException | SaldoInsuficienteException e) { }

        // Transferência válida
        try {
            cc1.transferir(cp1, 100.00);
        } catch (ValorInvalidoException | SaldoInsuficienteException | LimiteExcedidoException e) { }

        // Rendimento válido
        try {
            cp1.aplicarRendimento();
        } catch (SaldoNegativoException e) { }

        // Rendimento com saldo zero
        try {
            cp4.aplicarRendimento();
        } catch (SaldoNegativoException e) { }

        // Tarifa conta corrente
        cc1.cobrarTarifa();
        cc2.cobrarTarifa();
        cc3.cobrarTarifa();

        // ==================== RELATÓRIOS ====================

        System.out.println("\n---------- Extrato: Conta " + cc1.getNumero() + " ----------");
        cc1.getExtrato().exibirExtrato();

        System.out.println("\n---------- Extrato: Conta " + cp1.getNumero() + " ----------");
        cp1.getExtrato().exibirExtrato();

        System.out.println("\n---------- Extrato: Conta " + cc2.getNumero() + " ----------");
        cc2.getExtrato().exibirExtrato();

        System.out.println("\n---------- Extrato: Conta " + cp2.getNumero() + " ----------");
        cp2.getExtrato().exibirExtrato();

        System.out.println();
        banco.exibirClientesPorAgencia(0);
        System.out.println();
        banco.exibirClientesPorAgencia(1);
        System.out.println();
        banco.exibirClientesPorAgencia(2);

        System.out.println();
        banco.exibirRelatorioGeral();
    }
}
