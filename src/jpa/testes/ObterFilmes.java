package jpa.testes;

import java.util.List;

import jpa.infra.DAO;
import jpa.modelo.muitospramuitos.Ator;
import jpa.modelo.muitospramuitos.Filme;

public class ObterFilmes {
	
	public static void main(String[] args) {
		
		DAO<Filme> dao = new DAO<>(Filme.class);
		
		List<Filme> filmes = dao.consultar("filmesNotaMaiorQue", "nota", 8.5);
		
		for (Filme filme : filmes) {
			System.out.println(filme.getNome() + " => " + filme.getNota());
			
			for (Ator ator : filme.getAtores()) {
				System.out.println(ator.getNome());
			}
		}
	}
	
}
