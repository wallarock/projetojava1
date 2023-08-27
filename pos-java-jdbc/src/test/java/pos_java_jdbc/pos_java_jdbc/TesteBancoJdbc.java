package pos_java_jdbc.pos_java_jdbc;

import org.junit.Test;

import conexaojdbc.SingleConnection;
import dao.UserPosDao;
import model.Userposjava;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		//SingleConnection.getConnection();
		UserPosDao userPosDao = new UserPosDao();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(4L); //L para converter para longo
		userposjava.setNome("Maria");
		userposjava.setEmail("maria@teste.com");
		
		userPosDao.salvar(userposjava);
	}
	

}
