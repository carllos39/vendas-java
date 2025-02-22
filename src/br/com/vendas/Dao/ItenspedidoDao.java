package br.com.vendas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.conexao.Conexao;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Itenspedido;
import br.com.vendas.model.Produto;



public class ItenspedidoDao {
	private static Connection con= Conexao.getConnection(); 
	
	public void inserirItenspedido(Itenspedido itenspedido ){
String sql="INSERT INTO itenspedido(quantidade,valor,produto_id,cliente_id) Values(?,?,?,?)";
try {
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setDouble(1, itenspedido.getQuantidade());
	preparador.setDouble(2, itenspedido.getValor());
	preparador.setInt(3, itenspedido.getProduto_id());
	preparador.setInt(4, itenspedido.getCliente_id());
	preparador.execute();
	preparador.close();
	System.out.println("Itens cadastrado com sucesso!");
} catch (Exception e) {
	// TODO: handle exception
	System.out.println("Itens não cadastrado!");
}
}
	public void alterarItenspedido(Itenspedido itenspedido ){
String sql="UPDATE itenspedido SET quantidade=?,valor=?,produto_id=?,cliente_id=? WHERE id=?";
try {
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setDouble(1, itenspedido.getQuantidade());
	preparador.setDouble(2, itenspedido.getValor());
	preparador.setInt(3, itenspedido.getProduto_id());
	preparador.setInt(4, itenspedido.getCliente_id());
	preparador.setInt(5, itenspedido.getId());
	preparador.executeUpdate();
	preparador.close();
	System.out.println("Itens alterado com sucesso!");
} catch (Exception e) {
	// TODO: handle exception
	System.out.println("Itens não alterou!");
}
}
	public void excluirItenspedido(Itenspedido itenspedido ){
String sql="DELETE FROM itenspedido  WHERE id=?";
try {
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setInt(1, itenspedido.getId());
	preparador.execute();
	preparador.close();
	System.out.println("Itens excluido com sucesso!");
} catch (Exception e) {
	// TODO: handle exception
	System.out.println("Itens não excluido!");
}
}
	public List<Itenspedido>buscaTodos(){
		List<Itenspedido>listaItens=new ArrayList<Itenspedido>();
		String sql="SELECT itenspedido.*,produto.nome AS produto_nome,cliente.nome AS cliente_nome FROM itenspedido JOIN produto"
				+ "ON itenspedido.produto_id=produto.id JOIN cliente ON itenspedido.cliente_id=cliente.id";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		ResultSet resultado=preparador.executeQuery();
		while(resultado.next()){
	
			Itenspedido itenspedido=new Itenspedido();
			itenspedido.setId(resultado.getInt("id"));
			itenspedido.setQuantidade(resultado.getDouble("quantidade"));
			itenspedido.setValor(resultado.getDouble("valor"));
			itenspedido.setProduto_id(resultado.getInt("produto_id"));
			itenspedido.setCliente_id(resultado.getInt("cliente_id"));
			listaItens.add(itenspedido);	
		}
		preparador.close();
		System.out.println("Lista de itens carregada com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
		System.out.println("Lista de itens não carregada!");
		}
		return listaItens;
	}
	public List<Itenspedido>buscaUmItenspedido(Integer id){
		List<Itenspedido>listaItens=new ArrayList<Itenspedido>();
		String sql="SELECT * FROM itenspedido WHERE id=?";
		try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet resultado=preparador.executeQuery();
			while(resultado.next()){
				Itenspedido itenspedido=new Itenspedido();
				itenspedido.setId(resultado.getInt("id"));
			listaItens.add(itenspedido);
			}
			preparador.close();
			System.out.println(" Itens carregado com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Itens não carregado !");
		}
		return listaItens;
		
	}
}
