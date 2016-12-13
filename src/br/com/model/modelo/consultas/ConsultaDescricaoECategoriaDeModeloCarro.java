package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.util.JPAUtil;

public class ConsultaDescricaoECategoriaDeModeloCarro {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager();

		String jpql = "select mc.descricao, mc.categoria from ModeloCarro mc";
		
		@SuppressWarnings("unchecked")
		List<Object[]> resultados = em.createQuery(jpql).getResultList();
		
		resultados.forEach(r -> System.out.println("Descricao: "+ r[0] +" Categoria " + r[1]));
		
		em.close();
	}

}
