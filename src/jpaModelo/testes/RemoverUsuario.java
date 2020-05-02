package jpaModelo.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaModelo.Usuario;

public class RemoverUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-estudos");
		EntityManager em = emf.createEntityManager();
		
		Usuario usuario = em.find(Usuario.class, 6L);
		
		if(usuario != null) {
			em.getTransaction().begin();
			em.remove(usuario);
			em.getTransaction().commit();
		} else {
			System.out.println("Usuário não encontrado para exclusão.");
		}
		
		em.close();
		emf.close();
	}
	
}
