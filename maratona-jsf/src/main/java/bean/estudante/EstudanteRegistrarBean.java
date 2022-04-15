package bean.estudante;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.el.LambdaExpression;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import model.Estudante;

@Named("umNomeMaluco")
@ViewScoped
public class EstudanteRegistrarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Estudante estudante = new Estudante();
	private String[] nomesArray = {"DevDojo", "eh", "foda"};
	private List<String> nomesList = Arrays.asList("William", "Yitshhaq", "Brenon", "Sandy");
	private Set<String> nomesSet = new HashSet<>(Arrays.asList("Goku", "Vegeta", "Kuririn", "Frezza"));
	private Map<String, String> nomesMap = new HashMap<>();
	private boolean mostrarNotas = false;
	private boolean mostrarLink = false;
	
	
	{
	    nomesMap.put("Goku", "O mais forte");
	    nomesMap.put("One Piece", "O mais longo");
	    nomesMap.put("Naruto", "O mais lenga lenga");
	}
	
	public void executar() {
	    System.out.println("Fazendo uma busca no BD...");
	    System.out.println("Processando os dados...");
	    System.out.println("Exibindo os dados...\n");
	}
	
	public void executar(String param) {
	    System.out.println("Fazendo uma busca no BD..." + param);
	    System.out.println("Processando os dados..." + param);
	    System.out.println("Exibindo os dados..." + param + "\n");
	}
	
	public String executarComRetorno(String param) {
	    return "Quem é o lindão? " + param;
	}
	
	public String irParaIndex2() {
//	    return "index2?faces-redirect=true";
	    return "index2";
	}
	
	public void exibirNotas() {
	    this.mostrarNotas = true;
	}
	
	public void esconderNotas() {
	    this.mostrarNotas = false;
	}
	
	public void exibirLink() {
	    this.mostrarLink = true;
	}
	
	public void esconderLink() {
	    this.mostrarLink = false;
	}
	
	public void calcularCubo(LambdaExpression le, long value) {
	    long result = (long) le.invoke(FacesContext.getCurrentInstance().getELContext(), value);
	    
	    System.out.println(result);
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

    public boolean isMostrarNotas() {
        return mostrarNotas;
    }

    public void setMostrarNotas(boolean mostrarNotas) {
        this.mostrarNotas = mostrarNotas;
    }

    public boolean isMostrarLink() {
        return mostrarLink;
    }

    public void setMostrarLink(boolean mostrarLink) {
        this.mostrarLink = mostrarLink;
    }
    
    
    
}
