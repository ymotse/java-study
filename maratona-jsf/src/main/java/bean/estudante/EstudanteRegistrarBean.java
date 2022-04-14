package bean.estudante;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.inject.Named;

import model.Estudante;

@Named("umNomeMaluco")
public class EstudanteRegistrarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Estudante estudante = new Estudante();
	private String[] nomesArray = {"DevDojo", "eh", "foda"};
	private List<String> nomesList = Arrays.asList("William", "Yitshhaq", "Brenon", "Sandy");
	private Set<String> nomesSet = new HashSet<>(Arrays.asList("Goku", "Vegeta", "Kuririn", "Frezza"));
	private Map<String, String> nomesMap = new HashMap<>();
	
	{
	    nomesMap.put("Goku", "O mais forte");
	    nomesMap.put("One Piece", "O mais longo");
	    nomesMap.put("Naruto", "O mais lenga lenga");
	}
	
    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public String[] getNomesArray() {
        return nomesArray;
    }

    public void setNomesArray(String[] nomesArray) {
        this.nomesArray = nomesArray;
    }

    public List<String> getNomesList() {
        return nomesList;
    }

    public void setNomesList(List<String> nomesList) {
        this.nomesList = nomesList;
    }

    public Set<String> getNomesSet() {
        return nomesSet;
    }

    public void setNomesSet(Set<String> nomesSet) {
        this.nomesSet = nomesSet;
    }

    public Map<String, String> getNomesMap() {
        return nomesMap;
    }

    public void setNomesMap(Map<String, String> nomesMap) {
        this.nomesMap = nomesMap;
    }
    
}
