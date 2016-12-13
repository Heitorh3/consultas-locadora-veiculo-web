package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.util.JPAUtil;

public class ConsultaModeloFiltroEmFabricanteECategoria {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager(); 
		
		String jpql = "select mc.descricao from ModeloCarro mc "
	              	+ "where mc.fabricante.nome = 'Honda' "
	                + "and mc.categoria in ('SEDAN_MEIDO','SEDAN_GRANDE')";

		List<String> modelos = em.createQuery(jpql, String.class).getResultList();
		
		modelos.forEach(m -> System.out.println("Modelo " + m));
		em.close();

	}

}
