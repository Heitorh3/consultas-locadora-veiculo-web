package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.util.JPAUtil;

public class ConsultaFabricantesPeloModeloDoCarro {

	public static void main(String args[]){
		
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager(); 
		
		List<String>nomeDosFabricantes = em.createQuery("select mc.fabricante.nome from ModeloCarro mc", String.class).getResultList();
		
		nomeDosFabricantes.forEach(f -> System.out.println("Nome: " + f));
		
		em.close();
	}
}
