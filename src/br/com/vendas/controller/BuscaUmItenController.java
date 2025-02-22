package br.com.vendas.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.vendas.Dao.ClienteDao;
import br.com.vendas.Dao.ItenspedidoDao;
import br.com.vendas.Dao.ProdutoDao;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Itenspedido;
import br.com.vendas.model.Produto;


@WebServlet("/BuscaUmItenController")
public class BuscaUmItenController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuscaUmItenController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Integer id=Integer.parseInt(request.getParameter("id"));
		Produto produto=new Produto();
		produto.setId(id);
		ProdutoDao dao=new ProdutoDao();
		dao.buscaUmProduto(id);
		RequestDispatcher saida=request.getRequestDispatcher("itenspedido/formulario-itenspedido.jsp");
		saida.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Double quantidade=Double.parseDouble(request.getParameter("quantidade"));
		Double valor=Double.parseDouble(request.getParameter("valor"));
		int cliente_id=Integer.parseInt(request.getParameter("cliente_id"));
		int produto_id=Integer.parseInt(request.getParameter("produto_id"));
		
		Produto produto=new Produto();
		List<Produto>produtos=new ArrayList<Produto>();
		produtos.add(produto);
		
		Cliente cliente=new Cliente();
		List<Cliente>clientes=new ArrayList<Cliente>();
		clientes.add(cliente);
		
		Itenspedido itenspedido=new Itenspedido();
		itenspedido.setQuantidade(quantidade);
		itenspedido.setValor(valor);
		itenspedido.setCliente_id(cliente_id);
		itenspedido.setProduto_id(produto_id);
		
		
		ItenspedidoDao dao=new ItenspedidoDao();
		dao.inserirItenspedido(itenspedido);
	}

}
