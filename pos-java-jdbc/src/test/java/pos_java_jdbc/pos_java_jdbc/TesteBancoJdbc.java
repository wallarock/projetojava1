package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

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
	
	//Metodo para listar os dados gravados no banco
	@Test
	public void initListar() {
		UserPosDao dao = new UserPosDao();
		try {
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void initBuscar() {
		UserPosDao dao = new UserPosDao();
		
		try {
			Userposjava userposjava = dao.buscar(2L);
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
