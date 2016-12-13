package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.util.JPAUtil;

public class ConsultaModeloFiltrandoPeloFabricante {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager(); 

		List<String>modelos = em.createQuery("select mc.descricao from ModeloCarro mc where mc.fabricante.nome = 'BMW'", String.class).getResultList();
		
		modelos.forEach(md -> System.out.println("Modelos de carro: " + md));
		em.close();
		
	}

}
