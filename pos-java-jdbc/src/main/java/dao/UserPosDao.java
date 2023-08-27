/*Pacote DAO Objeto de acesso a dados */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDao {
	
	private Connection connection;
	
	public UserPosDao() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (Userposjava userposjava) {
		try {
			/*Prepara a query*/
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

}
