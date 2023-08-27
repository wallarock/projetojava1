/*Pacote DAO Objeto de acesso a dados */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDao {

	private Connection connection;

	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}

	public void salvar(Userposjava userposjava) {
		try {
			/* Prepara a query */
			String sql = "insert into userposjava (id, nome, email) values(?,?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

	}

	// Método para pesquisar uma LISTA do UserPosJava como objetos do banco
	public List<Userposjava> listar() throws Exception {
		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "SELECT id, nome, email FROM public.userposjava;";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery(); // ResultSet do Java SQL para trazer o resultado da query

		// Enquanto estiver dados, instancia o objeto a ser buscado
		while (resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));

			list.add(userposjava);

		}

		return list;
	}

	//Método para buscar apenas UM objeto do UserPosJava como objetos do banco
	public Userposjava buscar(Long id) throws Exception {
		Userposjava retorno = new Userposjava();

		String sql = "SELECT * FROM userposjava WHERE id = " + id;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery(); // ResultSet do Java SQL para trazer o resultado da query

		while (resultado.next()) { //Retorna apenas um usuário ou nenhum
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));

		}

		return retorno;
	}
}
