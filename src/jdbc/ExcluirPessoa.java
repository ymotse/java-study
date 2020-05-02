package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {
	
	public static void main(String[] args) throws SQLException {
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informe o código para exclusão: ");
		int codigo = entrada.nextInt();
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "DELETE FROM pessoas WHERE codigo = ?";
		
		PreparedStatement st = conexao.prepareStatement(sql);
		st.setInt(1, codigo);
		
		int contador = st.executeUpdate();
		if(contador > 0) {
			System.out.println("pessoa excluída com sucesso!");
			System.out.println("Linhas afetadas: " + contador);
		} else {
			System.out.println("Pessoa não encontrada para exclusão.");
		}
		
		conexao.close();
		entrada.close();
	}
	
}
