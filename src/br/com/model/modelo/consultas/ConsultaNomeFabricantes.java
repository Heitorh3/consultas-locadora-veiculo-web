package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.util.JPAUtil;

public class ConsultaNomeFabricantes {

	public static void main(String[] args) {

		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager(); 

		List<String> nomesDosFabricantes = em.createQuery("select f.nome from Fabricante f", String.class).getResultList();
		
		nomesDosFabricantes.forEach(f -> System.out.println("Nome do Fabricante: " + f));
		
		em.close();
	}
}
