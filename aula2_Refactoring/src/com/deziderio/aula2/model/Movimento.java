package com.deziderio.aula2.model;

import java.util.ArrayList;
import java.util.Date;

import com.deziderio.aula2.dao.MovimentoDao;

public class Movimento {

	private Date dataMovimento;
	private double valorOperacao;
	private MovimentoDao db;
	private int id;

	public Movimento(double valorOperacao) {
		dataMovimento = new Date();
		this.valorOperacao = valorOperacao;
		db = new MovimentoDao();
	}

	public Movimento() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public Date getDateTime() {
		return dataMovimento;
	}

	public void setDateTime(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public ArrayList<Movimento> consultarExtrato(Conta conta) {
		return db.consultarExtrato(conta);
	}

	public void incluirMovimento(Conta conta, Cliente cliente) {
		db.incluirMovimento(this, conta, cliente);
	}
}
