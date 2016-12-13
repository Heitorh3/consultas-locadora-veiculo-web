package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.util.JPAUtil;

public class ConsultaAcessorioPorModeloDeCarro {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager();

		String jpql = "select a.descricao from Carro c JOIN c.acessorios a where c.modelo.descricao = 'Z4'";
		
		@SuppressWarnings("unchecked")
		List<String> resultados = em.createQuery(jpql).getResultList();
		
		resultados.forEach(r -> System.out.println("Acessório: " + r));
		
		em.close();

	}

}
