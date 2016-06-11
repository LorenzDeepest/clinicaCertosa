package persistence;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Prerequisito;

public class PrerequisitoDao implements Dao<Prerequisito> {
	
	private EntityManager em;

	public PrerequisitoDao(EntityManager em) {
		this.em = em;
	}

	public void save(Prerequisito c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public Prerequisito findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prerequisito c = em.find(Prerequisito.class, id);
		tx.commit();
		return c;
	}

	public void delete(Prerequisito c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Prerequisito toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Prerequisito c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Prerequisito> findAll() {
		List<Prerequisito> result = new ArrayList<>(em.createNamedQuery("Prerequisito.findAll").getResultList());
		return result;
	}

	public void closeEmf() {
		em.close();
	}
	
	

}
