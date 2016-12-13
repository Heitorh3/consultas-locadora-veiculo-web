package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.Carro;
import br.com.model.modelo.util.JPAUtil;

public class ConsultasAgregadasEmCarro {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager();

		String jpql = "select c, count(a), avg(a.valorTotal), max(a.valorTotal) "
						+ "from Carro c JOIN c.alugueis a "
						+ "group by c "
						+ "having count(a) > 2";
		
		@SuppressWarnings("unchecked")
		List<Object[]> resultados = em.createQuery(jpql).getResultList();
		
		resultados.forEach(r -> System.out.println("Modelo: " + ((Carro)r[0]).getModelo().getDescricao() 
												+ " Quantidade de alugueis: " + r[1]
												+ " Valor maximo: " + r[2]
												+ " Valor médio: " + r[3]));
		em.close();

	}

}
