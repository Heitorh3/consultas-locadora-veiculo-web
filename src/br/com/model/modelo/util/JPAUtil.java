package br.com.model.modelo.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("locadoraPU"); 
	 	 
	 	public static EntityManager createEntityManager() { 
	 		return emf.createEntityManager(); 
	 	} 

	
}
