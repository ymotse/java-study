package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {
	
	public static void main(String[] args) throws SQLException {
		Scanner entrada = new Scanner(System.in);
		
		Connection conexao = FabricaConexao.getConexao();
		String sql = "SELECT * FROM pessoas WHERE nome LIKE ?";

		System.out.println("Informe o valor para pesquisa:");
		String valor = entrada.nextLine();
		entrada.close();
		
		PreparedStatement st = conexao.prepareStatement(sql);
		st.setString(1, "%" + valor + "%");
		ResultSet rs = st.executeQuery();
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		while(rs.next()) {
			int codigo = rs.getInt("codigo");
			String nome = rs.getString("nome");
			
			pessoas.add(new Pessoa(codigo, nome));
		}
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getCodigo() + " ==> " + pessoa.getNome());
		}
		
		st.close();
		conexao.close();
	}
	
}
