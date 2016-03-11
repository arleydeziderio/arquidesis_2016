package com.deziderio.aula2.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.deziderio.aula2.conexao.Conexao;
import com.deziderio.aula2.model.Cliente;
import com.deziderio.aula2.model.Conta;
import com.deziderio.aula2.model.Movimento;

public class MovimentoDao {

	public MovimentoDao() {

	}

	public void incluirMovimento(Movimento mov, Conta conta, Cliente cliente) {
		String sqlInsert = "INSERT INTO Movimento(atmDataOp,atmValorOp,Conta_atmConta,Conta_Cliente_idCliente) VALUES (?, ?, ?, ?)";

		try (Connection conn = new Conexao().conectar(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			Date date = new Date(System.currentTimeMillis());
			stm.setDate(1, date);
			stm.setDouble(2, mov.getValorOperacao());
			stm.setInt(3, conta.getConta());
			stm.setInt(4, cliente.getIdCliente());
			stm.execute();

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	public ArrayList<Movimento> consultarExtrato(Conta conta) {

		String sqlSelect = "SELECT * FROM Movimento WHERE Conta.id = ? ";
		ArrayList<Movimento> list = new ArrayList<Movimento>();

		try (Connection conn = new Conexao().conectar(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conta.getConta());

			try (ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {

					Movimento mov = new Movimento();

					mov.setId(rs.getInt("atmMovId"));
					mov.setValorOperacao(rs.getDouble("atmValorOp"));
					mov.setDateTime(rs.getDate("atmDataOp"));

					list.add(mov);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}
}
