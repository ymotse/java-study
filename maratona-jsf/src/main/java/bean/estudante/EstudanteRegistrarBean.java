package bean.estudante;

import java.io.Serializable;

import javax.inject.Named;

import model.Estudante;

@Named("umNomeMaluco")
public class EstudanteRegistrarBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Estudante estudante = new Estudante();

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
	
}
