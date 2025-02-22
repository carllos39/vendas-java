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
import br.com.vendas.Dao.ItenspedidoDao;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Itenspedido;


@WebServlet("/ItensController")
public class ItensController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ItensController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ItenspedidoDao dao=new ItenspedidoDao();
		List<Itenspedido>listaitens=dao.buscaTodos();
		request.setAttribute("listaitens",listaitens);
		RequestDispatcher saida=request.getRequestDispatcher("itenspedido/formulario-itenspedido.jsp");
		saida.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
