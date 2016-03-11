package com.deziderio.aula2.model;

public class Conta {

	private int agencia;
	private int conta;
	private int senha;
	private double saldo;

	public Conta(int conta) {
		this.conta = conta;
	}

	public Conta(int agencia, int conta, int senha) {
		this.agencia = agencia;
		this.conta = conta;
		this.senha = senha;
		this.saldo = 0;
	}

	public int getAgencia() {
		return agencia;
	}

	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}

	public int getConta() {
		return conta;
	}

	public void setConta(int conta) {
		this.conta = conta;
	}

	public int getSenha() {
		return senha;
	}

	public void setSenha(int senha) {
		this.senha = senha;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
}
