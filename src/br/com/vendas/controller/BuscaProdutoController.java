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


@WebServlet("/BuscaProdutoController")
public class BuscaProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BuscaProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		ProdutoDao dao=new ProdutoDao();
		request.setAttribute("produto",dao.buscaUmProduto(id));
		RequestDispatcher saida=request.getRequestDispatcher("produto/formulario-produto.jsp");
		saida.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome=request.getParameter("nome");
		String descricao=request.getParameter("descricao");
		Double valor=Double.parseDouble(request.getParameter("valor"));
		String id=request.getParameter("id");
		
		Produto produto=new Produto(); 
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		produto.setId(Integer.parseInt(id));
		ProdutoDao dao=new ProdutoDao();
		dao.alterarProduto(produto);
		RequestDispatcher saida=request.getRequestDispatcher("formulario-produto.jsp");
		saida.forward(request, response);
	}

}
