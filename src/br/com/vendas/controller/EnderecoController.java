package br.com.vendas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.Dao.EnderecoDao;
import br.com.vendas.model.Endereco;


@WebServlet("/EnderecoController")
public class EnderecoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public EnderecoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		EnderecoDao dao=new EnderecoDao();
		List<Endereco>listaEnderecos=dao.buscaTodosEnderecos();
		request.setAttribute("listaEnderecos",listaEnderecos);
		RequestDispatcher saida=request.getRequestDispatcher("endereco/formulario-endereco.jsp");
		saida.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}

}
