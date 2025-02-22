package br.com.vendas.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.Dao.ProdutoDao;
import br.com.vendas.model.Produto;


@WebServlet("/ProdutoController")
public class ProdutoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ProdutoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProdutoDao dao=new ProdutoDao();
		List<Produto>listaProduto=dao.buscaTodosProduto();
		request.setAttribute("listaProduto", listaProduto);
		RequestDispatcher saida=request.getRequestDispatcher("produto/formulario-produto.jsp");
		saida.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nome=request.getParameter("nome");
		String descricao=request.getParameter("descricao");
		Double valor=Double.parseDouble(request.getParameter("valor"));
		
		Produto produto=new Produto(); 
		produto.setNome(nome);
		produto.setDescricao(descricao);
		produto.setValor(valor);
		ProdutoDao dao=new ProdutoDao();
		dao.inserirProduto(produto);
		
	}

}
