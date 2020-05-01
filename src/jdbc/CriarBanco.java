package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {
	
	public static void main(String[] args) throws SQLException {
		
		final String url = "jdbc:mysql://localhost:3308?verifyServerCertificate=false&useSSL=true";
		final String usuario = "root";
		final String senha = "ymotse";
		
		Connection conexao = DriverManager.getConnection(url, usuario, senha); 
		
		System.out.println("Conexao efetuada com sucesso!");
		
		Statement stmt = conexao.createStatement();
		stmt.execute("CREATE DATABASE IF NOT EXISTS curso_java");
		System.out.println("Banco criado com sucesso!");

		conexao.close();
		
	}
	
}
