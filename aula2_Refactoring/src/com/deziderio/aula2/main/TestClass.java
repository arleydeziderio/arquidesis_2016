package com.deziderio.aula2.main;

import java.util.List;

import com.deziderio.aula2.model.Cliente;
import com.deziderio.aula2.model.Conta;
import com.deziderio.aula2.model.Movimento;
import com.deziderio.aula2.model.Saque;

/*
 * Classe de teste para o refactoring dos casos de uso 
 * Consultar extrado e Efetuar Saque.
 * 
 * Foram respeitadas as regras de negócio do caixa eletronico para fazer os testes.
 * Considere trocar sua senha e nome de banco de dados para executar os testes
 * @see Conexao 
 * @author Arley Deziderio
 * @author Francisco Olvera 
 */

public class TestClass {

	public static void main(String[] args) {

		// instanciamos os atributos necessarios para realizar os casos de uso
		Movimento movimento = new Movimento(2000.00);
		Saque saque = new Saque(movimento.getValorOperacao());
		boolean saq;
		Conta conta = new Conta(12345, 2345, 67890);

		System.out.println("Saldo atual do cliente: " + conta.getSaldo());

		// efetuamos o saque
		saq = saque.fazerSaque();

		if (saq)
			System.out.println("Saque realizado com sucesso!!");
		else
			System.out.println("Falha na realização do saque!");

		// incluimos um novo movimento na tabela de movimentos
		movimento.incluirMovimento(conta, new Cliente(1));

		System.out.println("Consulta de extrato");

		List<Movimento> list = movimento.consultarExtrato(conta);

		System.out.println("Todos os Movimentos efetuados pelo cliente:");
		for (Movimento mov : list) {
			System.out.println(mov.toString());
		}
		// reconsultamos o saldo depois do saque
		System.out.println("Saldo atual do cliente: " + conta.getSaldo());
		System.out.println("Fim da operação!!");
		System.out.println("Até logo");
	}
}