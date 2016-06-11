package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import model.Risultato;


public class RisultatoDao implements Dao<Risultato>{
	
	private EntityManager em;

	public RisultatoDao(EntityManager em) {
		this.em = em;
	}

	public void save(Risultato c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public Risultato findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Risultato c = em.find(Risultato.class, id);
		tx.commit();
		return c;
	}

	public void delete(Risultato c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Risultato toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Risultato c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Risultato> findAll() {
		List<Risultato> result = em.createNamedQuery("Risultato.findAll").getResultList();
		return result;
	}

	public void closeEmf() {
		em.close();
	}
	
	

}
