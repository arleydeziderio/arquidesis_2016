package com.deziderio.aula2.model;

public class Saque extends Movimento {

	private Dispenser dispenser;

	public Saque(double valorOperacao) {
		super(valorOperacao);
		dispenser = new Dispenser();
	}

	public boolean fazerSaque() {
		dispenser.contarNotas(super.getValorOperacao());
		super.getValorOperacao();
		return true;
	}
}
