package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	
	private Connection conexao;
	
	public int incluir(String sql, Object...atributos) {
		try {
			PreparedStatement st = getConexao().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			
			adicionarAtributos(st, atributos);
			
			if(st.executeUpdate() > 0) {
				ResultSet rs = st.getGeneratedKeys();
				
				if(rs.next()) {
					return rs.getInt(1);
				}
			}
			
			return -1;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private void adicionarAtributos(PreparedStatement st, Object[] atributos) throws SQLException {
		
		int indice = 1;
		for (Object atributo : atributos) {
			if(atributo instanceof String) {
				st.setString(indice, (String) atributo);
			} else if(atributo instanceof Integer) {
				st.setInt(indice, (Integer) atributo);
			}
			
			indice++;
		}
	}
	
	private Connection getConexao() {
		try {
			if(conexao != null && !conexao.isClosed()) {
				return conexao;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		conexao = FabricaConexao.getConexao();
		return conexao;
	}
	
	public void close() {
		try {
			getConexao().close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conexao = null;
		}
	}
	
}
