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


@WebServlet("/BuscaClienteController")
public class BuscaClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BuscaClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		ClienteDao dao=new ClienteDao();
		request.setAttribute("cliente",dao.buscaUmCliente(id));
		RequestDispatcher saida=request.getRequestDispatcher("cliente/formulario-cliente-alterar.jsp");
		saida.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome=request.getParameter("nome");
		String email=request.getParameter("email");
		String senha=request.getParameter("senha");
		String id=request.getParameter("id");
		Cliente cliente=new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setSenha(senha);
		cliente.setId(Integer.parseInt(id));
		
		ClienteDao dao=new ClienteDao();
		dao.alterarCliente(cliente);
		RequestDispatcher saida=request.getRequestDispatcher("formulario-cliente.jsp");
		saida.forward(request, response);
		
	}

}
