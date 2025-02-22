package br.com.vendas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.conexao.Conexao;
import br.com.vendas.model.Cliente;


public class ClienteDao {
	private static Connection con=Conexao.getConnection();
	
	public boolean validarCliente(Cliente cliente){
		String sql="SELECT * FROM cliente WHERE email=? AND senha=?";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setString(1,cliente.getEmail());
		preparador.setString(2,cliente.getSenha());
		ResultSet resultado=preparador.executeQuery();
		if(resultado.next()){
			System.out.println("Usuário encontrado!");
			return true;
		}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;	
}
	public void inserirCliente(Cliente cliente){
		String sql="INSERT INTO cliente(nome,email,senha) VALUES(?,?,?)";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setString(1,cliente.getNome());
		preparador.setString(2,cliente.getEmail());
		preparador.setString(3,cliente.getSenha());
		preparador.execute();
		preparador.close();
		System.out.println("Cliente cadastrado com sucesso!");
		
		} catch (Exception e) {
			System.out.println("Cliente não cadastrou!");
		}
	}
		public void alterarCliente(Cliente cliente){
			String sql="UPDATE cliente SET nome=?,email=?,senha=? WHERE id=?";
			try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setString(1,cliente.getNome());
			preparador.setString(2,cliente.getEmail());
			preparador.setString(3,cliente.getSenha());
			preparador.setInt(4,cliente.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Cliente alterado com sucesso!");
			
			} catch (Exception e) {
				System.out.println("Cliente não alterou!");
			}
			
}
		public void excluirCliente(Cliente cliente){
			String sql="DELETE FROM cliente WHERE id=?";
			try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setInt(1,cliente.getId());
			preparador.execute();
			preparador.close();
			System.out.println("Cliente excluido com sucesso!");
			
			} catch (Exception e) {
				System.out.println("Cliente não excluido!");
			}
		}
			public List<Cliente>buscaTodos(){
				List<Cliente>lista=new ArrayList<Cliente>();
				String sql="SELECT * FROM cliente";
				try {
				PreparedStatement preparador=con.prepareStatement(sql);
				ResultSet resultado=preparador.executeQuery();
				while(resultado.next()){
					Cliente cliente=new Cliente();
					cliente.setId(resultado.getInt("id"));
					cliente.setNome(resultado.getString("nome"));
					cliente.setEmail(resultado.getString("email"));
					lista.add(cliente);
				}
					preparador.close();
					System.out.println("Lista carregada com sucesso!");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Lista não carregada!");
				}
				return lista;	
		
			
				}
			public List<Cliente>buscaUmCliente(Integer id){
				List<Cliente>lista=new ArrayList<Cliente>();
				String sql="SELECT * FROM cliente WHERE id=?";
				try {
				PreparedStatement preparador=con.prepareStatement(sql);
				preparador.setInt(1, id);
				ResultSet resultado=preparador.executeQuery();
				while(resultado.next()){
					Cliente cliente=new Cliente();
					cliente.setId(resultado.getInt("id"));
					lista.add(cliente);
				}
				System.out.println("Id carregado com sucesso!");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Id não carregou!");
				}
				return lista;
			}
}

		
	


