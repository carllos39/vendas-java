package br.com.vendas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.Dao.ClienteDao;
import br.com.vendas.model.Cliente;


@WebServlet("/ClienteController")
public class ClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ClienteDao dao=new ClienteDao();
		List<Cliente>lista=dao.buscaTodos();
		request.setAttribute("lista", lista);
		RequestDispatcher saida=request.getRequestDispatcher("cliente/formulario-cliente.jsp");
		saida.forward(request, response);
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		Cliente cliente=new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		
		ClienteDao dao=new ClienteDao();
		dao.inserirCliente(cliente);
	}

}
