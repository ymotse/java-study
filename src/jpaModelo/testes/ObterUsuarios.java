package jpaModelo.testes;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import jpaModelo.Usuario;

public class ObterUsuarios {
	
	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("java-estudos");
		EntityManager em = emf.createEntityManager();
		
		List<Usuario> usuarios = em
				.createQuery("select u from Usuario u", Usuario.class)
				.setMaxResults(5)
				.getResultList();
		
		for (Usuario usuario : usuarios) {
			System.out.println("Id: " + usuario.getId() + 
					" | Nome: " + usuario.getNome() + 
					" | E-mail: " + usuario.getEmail());
		}
		
		em.close();
		emf.close();
	}
	
}
