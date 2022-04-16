package bean.application;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class TesteApplicationBean implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private List<String> categoriaList;
    
    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ApplicationScoped");
        categoriaList = Arrays.asList("RPG", "Sci-fi", "Terror");
    }

    public void mudarLista() {
        categoriaList = Arrays.asList("RPG", "Sci-fi", "Terror", "Action");
    }
    
    
    public List<String> getCategoriaList() {
        return categoriaList;
    }

    public void setCategoriaList(List<String> categoriaList) {
        this.categoriaList = categoriaList;
    }
    
}
