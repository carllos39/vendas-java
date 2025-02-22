package br.com.vendas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.conexao.Conexao;
import br.com.vendas.model.Produto;

public class ProdutoDao {
	private static Connection con=Conexao.getConnection();
	
	public void inserirProduto(Produto produto){
		String sql="INSERT INTO produto(nome,descricao,valor) VALUES(?,?,?)";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setString(1,produto.getNome());
		preparador.setString(2,produto.getDescricao());
		preparador.setDouble(3,produto.getValor());
		preparador.execute();
		preparador.close();
		System.out.println("Produto cadastrado com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Produto não cadastrado!");
		}
	}
		public void alterarProduto(Produto produto){
			String sql="UPDATE produto SET nome=?,descricao=?,valor=? where id=?";
			try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setString(1,produto.getNome());
			preparador.setString(2,produto.getDescricao());
			preparador.setDouble(3,produto.getValor());
			preparador.setInt(4,produto.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Produto alterado com sucesso!");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Produto não alterado!");
			}
	}
public void excluirProduto(Produto produto){
	String sql="DELETE FROM produto where id=?";
	try {
	PreparedStatement preparador=con.prepareStatement(sql);
	preparador.setInt(1,produto.getId());
	preparador.execute();
	preparador.close();
	System.out.println("Produto excluido com sucesso!");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Produto não excluido!");
	}
}
public List<Produto>buscaTodosProduto(){
	List<Produto>listaProduto=new ArrayList<Produto>();
	String sql="SELECT*FROM produto";
	try {
		PreparedStatement preparador=con.prepareStatement(sql);
		ResultSet resultado=preparador.executeQuery();
		while(resultado.next()){
			Produto produto=new Produto();
			produto.setId(resultado.getInt("id"));
			produto.setNome(resultado.getString("nome"));
			produto.setDescricao(resultado.getString("descricao"));
			produto.setValor(resultado.getDouble("valor"));
			listaProduto.add(produto);
		}
		preparador.close();
		System.out.println("Lista produto carregada com sucesso!");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Lista produto não carregou!");
	}
	return listaProduto;
}



public List<Produto>buscaUmProduto(Integer id){
	List<Produto>listaProduto=new ArrayList<Produto>();
	String sql="SELECT * FROM produto WHERE id=?";
	try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setInt(1, id);
		ResultSet resultado=preparador.executeQuery();
		while(resultado.next()){
			Produto produto=new Produto();
			produto.setId(resultado.getInt("id"));
			listaProduto.add(produto);
		}
		preparador.close();
		System.out.println(" Produto Id carregada com sucesso!");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println(" Produto Id não carregou!");
	}
	return listaProduto;
}


}
