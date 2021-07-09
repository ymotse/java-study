package locadora.servicos;

import locadora.entidades.Usuario;

public interface EmailService {
    
    public void notificarAtraso(Usuario usuario);
    
}
