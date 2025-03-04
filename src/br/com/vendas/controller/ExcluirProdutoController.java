package br.com.vendas.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.Dao.ProdutoDao;
import br.com.vendas.model.Produto;


@WebServlet("/ExcluirProdutoController")
public class ExcluirProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ExcluirProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		Produto produto=new Produto();
		produto.setId(id);
		
		ProdutoDao dao=new ProdutoDao();
		dao.excluirProduto(produto);
		RequestDispatcher saida=request.getRequestDispatcher("formulario-produto.jsp");
		saida.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
