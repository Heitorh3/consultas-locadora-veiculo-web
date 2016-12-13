package br.com.model.modelo.consultas;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.model.modelo.info.AlguelCarroInfo;
import br.com.model.modelo.util.JPAUtil;

public class ConsultasAgregadasEmCarroComClasse {

	public static void main(String[] args) {
		EntityManagerFactory emf = JPAUtil.createEntityManager().getEntityManagerFactory(); 
		EntityManager em = emf.createEntityManager();

		String jpql = "select NEW br.com.model.modelo.info.AlguelCarroInfo(c, count(a), max(a.valorTotal), avg(a.valorTotal)) "
						+ "from Carro c JOIN c.alugueis a "
						+ "group by c "
						+ "having count(a) > 2";
		
		@SuppressWarnings("unchecked")
		List<AlguelCarroInfo> resultados = em.createQuery(jpql).getResultList();
		
		resultados.forEach(r -> System.out.println(" Modelo: " + r.getCarro().getModelo().getDescricao() 
												+ "\n Quantidade de alugueis: " + r.getTotalAlugueis()
												+ "\n Valor maximo: " + r.getValorMaximo()
												+ "\n Valor médio: " + r.getValorMedio()));
		
		em.close();

	}

}
