package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o código da pessoa:");
		int codigo = entrada.nextInt();
		
		String selectSQL = "SELECT * FROM pessoas WHERE codigo = ?";
		String updateSQL = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
		
		Connection conexao = FabricaConexao.getConexao();
		PreparedStatement st = conexao.prepareStatement(selectSQL);
		st.setInt(1, codigo);
		
		ResultSet rs = st.executeQuery();
		
		if(rs.next()) {
			Pessoa p = new Pessoa(rs.getInt(1), rs.getString(2));
			
			System.out.println("O nome atual é " + p.getNome());
			entrada.nextLine();
			
			System.out.println("Informe o novo nome: ");
			String novoNome = entrada.nextLine();
			
			st.close();
			st = conexao.prepareStatement(updateSQL);
			st.setString(1, novoNome);
			st.setInt(2, codigo);
			st.execute();
			
			System.out.println("Pessoa alterada com sucesso!");
		} else {
			System.out.println("Pessoa não encontrada.");
		}
		
		conexao.close();
		entrada.close();
	}
	
}
