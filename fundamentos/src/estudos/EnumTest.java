package estudos;

public class EnumTest {

	// Enum (Enumeradores, constantes Enum Java);
	
	
	
	public static void main(String[] args) {
		
		System.out.println(EnumPecasXadrez.BISPO);
		
		System.out.println(EnumMedidas.M.titulo);
		
		// Percorrer todas constantes de um Enum:
		for(EnumMedidas m : EnumMedidas.values()){
			System.out.println(m+" : "+m.titulo);
		}
		

	}

}
