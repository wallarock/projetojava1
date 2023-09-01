package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.ModelLogin;

//O chamado Controller são as Servlets, ou ServletLoginController

//@WebServlet("/ServletLogin") //Mapeamento de URL que vem da tela (não funciona na versão 10.1.13 do Tomcat)
public class ServletLogin extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       

    public ServletLogin() {
             
    }

	//Recebe os dados pela URL em parâmetros
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	//Recebe os dados emviados por um formulário
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		//Validação dos dados de login
		if(login != null && !login.isEmpty() && senha != null && !senha.isEmpty()) {
			
		ModelLogin modelLogin = new ModelLogin();
		modelLogin.setLogin(login);
		modelLogin.setSenha(senha);
		
		}else {
			//Redireciona para o index.jsp
			RequestDispatcher redirecionar = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Informe o login e a senha corretamente!");
			redirecionar.forward(request, response);
			
		}
		
	}

}
