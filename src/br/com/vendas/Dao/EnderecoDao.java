package br.com.vendas.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.vendas.conexao.Conexao;
import br.com.vendas.model.Cliente;
import br.com.vendas.model.Endereco;


public class EnderecoDao {
	private static Connection con=Conexao.getConnection();
	
	public void inserirEndereco(Endereco endereco){
		String sql="INSERT INTO endereco(logradouro,numero,bairro,cidade,estado,cliente_id) VALUES(?,?,?,?,?,?)";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setString(1,endereco.getLogradouro());
		preparador.setInt(2,endereco.getNumero());
		preparador.setString(3,endereco.getBairro());
		preparador.setString(4,endereco.getCidade());
		preparador.setString(5,endereco.getEstado());
		preparador.setInt(6,endereco.getCliente_id());
		preparador.execute();
		preparador.close();
		System.out.println("Endereço cadastrado com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Endereço não cadastrado!" + e.getMessage());
		}
	}
	public void alterarEndereco(Endereco endereco){
		String sql="UPDATE endereco SET logradouro=?,numero=?,bairro=?,cidade=?,estado=? WHERE id=?)";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setString(1,endereco.getLogradouro());
		preparador.setInt(2,endereco.getNumero());
		preparador.setString(3,endereco.getBairro());
		preparador.setString(4,endereco.getCidade());
		preparador.setString(5,endereco.getEstado());
		preparador.setInt(6,endereco.getId());
		preparador.execute();
		preparador.close();
		System.out.println("Endereço alterado com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Endereço não alterou!");
		}
	}
	public void excluirEndereco(Endereco endereco){
		String sql="DELETE FROM endereco  WHERE id=?)";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		preparador.setInt(1,endereco.getId());
		System.out.println("Endereço excluido com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Endereço não excluido!");
		}
	}
	public List<Endereco>buscaTodosEnderecos(){
	
		List<Endereco>listaEnderecos=new ArrayList<Endereco>();
		String sql="SELECT endereco.*,cliente.nome AS cliente_nome FROM endereco JOIN cliente ON endereco.cliente_id=cliente.id";
		try {
		PreparedStatement preparador=con.prepareStatement(sql);
		ResultSet resultado=preparador.executeQuery();
		while(resultado.next()){
			Endereco endereco=new Endereco();
			Cliente cliente=new Cliente();
			List<Cliente>clientes=new ArrayList<Cliente>();
			clientes.add(cliente);
			endereco.setId(resultado.getInt("id"));
			endereco.setLogradouro(resultado.getString("logradouro"));
			endereco.setNumero(resultado.getInt("numero"));
			endereco.setBairro(resultado.getString("bairro"));
			endereco.setCidade(resultado.getString("cidade"));
			endereco.setEstado(resultado.getString("estado"));
			endereco.setCliente_id(resultado.getInt("cliente_id"));
			
			listaEnderecos.add(endereco);	
		}
		preparador.close();
		System.out.println("Lista de endereço carregada  com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lista de endereço não carregou!" + e.getMessage());
		}
		return listaEnderecos;
	}
	
	public List<Endereco>buscaUmEndereco(Integer id){
		List<Endereco>listaEnderecos=new ArrayList<Endereco>();
		String sql="SELECT * FROM endereco WHERE id=?";
		try {
			PreparedStatement preparador=con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet resultado=preparador.executeQuery();
			while(resultado.next()){
				Endereco endereco=new Endereco();
				endereco.setId(resultado.getInt("id"));
				listaEnderecos.add(endereco);
			}
			preparador.close();
			System.out.println(" Endereço Id carregada com sucesso!");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(" Endereço Id não carregou!");
		}
		return listaEnderecos;
	}

}
