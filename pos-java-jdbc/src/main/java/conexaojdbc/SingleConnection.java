package conexaojdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	/*Atributos estaticos para conexão com o banco de dados*/
	private static String url = "jdbc:postgresql://localhost:5432/posjava";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;
	
	/*Static é chamado direto para não precisar conectar manualmente*/
	static {
		Conectar();
	}
	
	/*Classe para conexão*/
	public SingleConnection() {
		Conectar();
	}
	
	/*Método privado para conexão com o banco de dados*/
	private static void Conectar() {
		try {
			/*condição if garante que a conexão será feita somente uma vez e se manter*/
			if(connection == null) {
				/*Carrega o driver do banco em questão*/
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(url, user, password);
				/*Não perite o commit automático*/
				connection.setAutoCommit(false);
				System.out.println("Conexão efetuda com sucesso!");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static Connection getConnection(){
		return connection;
	}

}
