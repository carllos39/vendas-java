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


@WebServlet("/ExcluirClienteController")
public class ExcluirClienteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ExcluirClienteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		Cliente cliente=new Cliente();
		cliente.setId(id);
		ClienteDao dao=new ClienteDao();
		dao.excluirCliente(cliente);
		RequestDispatcher saida=request.getRequestDispatcher("formulario-cliente.jsp");
		saida.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
