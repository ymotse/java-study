package jpaModelo.testes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaModelo.Usuario;

public class NovoUsuario {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-estudos");
		EntityManager em = emf.createEntityManager();
		
		Usuario novoUsuario = new Usuario("Isac", "isac@lanche.com.br");
		
		em.getTransaction().begin();
		em.persist(novoUsuario);
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}
	
}
