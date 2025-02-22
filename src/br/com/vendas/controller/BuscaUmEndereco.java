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
import br.com.vendas.Dao.EnderecoDao;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Endereco;


@WebServlet("/BuscaUmEndereco")
public class BuscaUmEndereco extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BuscaUmEndereco() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer id=Integer.parseInt(request.getParameter("id"));
		Cliente cliente=new Cliente();
		cliente.setId(id);
		ClienteDao dao=new ClienteDao();
		dao.buscaUmCliente(id);
		RequestDispatcher saida=request.getRequestDispatcher("endereco/formulario-endereco.jsp");
		saida.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer cliente_id=Integer.parseInt(request.getParameter("cliente_id"));
		String logradouro=request.getParameter("logradouro");
		Integer numero=Integer.parseInt(request.getParameter("numero"));
		String bairro=request.getParameter("bairro");
		String cidade=request.getParameter("cidade");
		String estado=request.getParameter("estado");
		
		Cliente cliente=new Cliente();
		List<Cliente>clientes=new ArrayList<Cliente>();
		clientes.add(cliente);
		
	
	
		
		Endereco endereco=new Endereco();
		cliente.setId(cliente_id);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setBairro(bairro);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		
		
	
       EnderecoDao dao=new EnderecoDao();
       dao.inserirEndereco(endereco);
	}

}
