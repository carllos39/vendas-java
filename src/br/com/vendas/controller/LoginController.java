package br.com.vendas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.Dao.ClienteDao;
import br.com.vendas.model.Cliente;



@WebServlet(urlPatterns={"/cliente/LoginController","/LoginController"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		String url=request.getParameter("url");
		
		if(email!= null && !email.isEmpty()&& senha != null && !senha.isEmpty()){
			Cliente cliente=new Cliente();
			cliente.setEmail(email);
			cliente.setSenha(senha);
			ClienteDao dao=new ClienteDao();
			if(dao.validarCliente(cliente)){	
			request.setAttribute("usuario",cliente.getEmail());
			if(url==null ||url.equals("null")){
				url="cliente/formulario-cliente.jsp";
			}
			RequestDispatcher saida=request.getRequestDispatcher(url);
			saida.forward(request, response);
		}else{
		RequestDispatcher saida=request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg","Informe o email e senha corretamente! ");
		saida.forward(request, response);
		}
	}else{
		RequestDispatcher saida=request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg","Informe o email e senha corretamente! ");
		saida.forward(request, response);
}
	}
}
