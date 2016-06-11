package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Specializzazione;

public class SpecializzazioneDao implements Dao<Specializzazione> {
	
	private EntityManager em;

	public SpecializzazioneDao(EntityManager em) {
		this.em = em;
	}

	public void save(Specializzazione c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public Specializzazione findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Specializzazione c = em.find(Specializzazione.class, id);
		tx.commit();
		return c;
	}

	public void delete(Specializzazione c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Specializzazione toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Specializzazione c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Specializzazione> findAll() {
		List<Specializzazione> result = em.createNamedQuery("Specializzazione.findAll").getResultList();
		return result;
	}

	public void closeEmf() {
		em.close();
	}
	
	
	
	

}
