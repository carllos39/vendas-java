package br.com.vendas.conexao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
public static Connection getConnection(){
	Connection con=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost/vendadb","root","root");
		System.out.println("Conectado com sucesso!");
	} catch (Exception e) {
		// TODO: handle exception
		System.out.println("Não conectou!"+ e.getMessage());
	}
	return con;
}

}
