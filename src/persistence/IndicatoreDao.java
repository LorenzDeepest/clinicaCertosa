package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Indicatore;;


public class IndicatoreDao implements Dao<Indicatore>{
	
	private EntityManager em;

	public IndicatoreDao(EntityManager em) {
		this.em = em;
	}

	public void save(Indicatore c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public Indicatore findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Indicatore c = em.find(Indicatore.class, id);
		tx.commit();
		return c;
	}

	public void delete(Indicatore c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Indicatore toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Indicatore c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Indicatore> findAll() {
		List<Indicatore> result = new ArrayList<>(em.createNamedQuery("Indicatore.findAll").getResultList());
		return result;
	}

	public void closeEmf() {
		em.close();
	}
	
	

}
