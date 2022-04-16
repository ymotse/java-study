package bean.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TesteViewBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<String> personagens;
    private List<String> personagemSelecionado = new ArrayList<>();
    
    @PostConstruct
    public void init() {
        System.out.println("Entrou no PostConstruct do ViewScoped");
        personagens = Arrays.asList("Naruto", "Hinata", "Yondaime");
    }
    
    public void selecionarPersonagem() {
        int index = ThreadLocalRandom.current().nextInt(3);
        String personagem = personagens.get(index);
        personagemSelecionado.add(personagem);
    }
    
    public void limparSelecaoPersonagem() {
        this.personagemSelecionado.clear();
    }
    
    public List<String> getPersonagemSelecionado() {
        return personagemSelecionado;
    }

    public void setPersonagemSelecionado(List<String> personagemSelecionado) {
        this.personagemSelecionado = personagemSelecionado;
    }
    
}