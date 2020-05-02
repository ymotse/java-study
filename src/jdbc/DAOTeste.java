package jdbc;

public class DAOTeste {
	
	public static void main(String[] args) {
		
		DAO dao = new DAO();
		
		String sql = "INSERT INTO pessoas(nome) VALUES(?)";
		System.out.println(dao.incluir(sql, "Roberto da Silva"));
		System.out.println(dao.incluir(sql, "Joana Sales"));
		System.out.println(dao.incluir(sql, "Daniele Tales"));
		System.out.println(dao.incluir(sql, "João Abinael"));
		
		dao.close();
	}
	
}
