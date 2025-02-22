package br.com.vendas.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import br.com.vendas.conexao.Conexao;


@WebFilter(urlPatterns={"/cliente/*"})
public class FilterCliente implements Filter {
private static Connection con=Conexao.getConnection();
    
    public FilterCliente() {
        // TODO Auto-generated constructor stub
    }

	
	public void destroy() {
		// TODO Auto-generated method stub
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			HttpServletRequest resq=(HttpServletRequest)request;
			HttpSession session=resq.getSession();
			String usurioLogado=(String)session.getAttribute("usuario");
			String urlParaAutenticar=resq.getServletPath();
			
			if(usurioLogado == null && !urlParaAutenticar.equalsIgnoreCase("/cliente/LoginController") && 
					!urlParaAutenticar.equalsIgnoreCase("/LoginController")){
				RequestDispatcher saida=request.getRequestDispatcher("/index.jsp?url" + urlParaAutenticar);
				saida.forward(request, response);
				return;
			}else{

				chain.doFilter(request, response);	
			}
			con.commit();
	} catch (Exception e) {
		// TODO: handle exception
		try {
			con.rollback();	
		} catch (Exception e2) {
			// TODO: handle exception
	 e2.printStackTrace();
		}
	
	}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		con=Conexao.getConnection();
	}

}
