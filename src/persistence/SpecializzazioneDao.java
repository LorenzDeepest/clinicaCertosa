package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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
	@SuppressWarnings("unchecked")
	public List<Specializzazione> findByIdMedico(long id){
		Query query = em.createNamedQuery("Specializzazione.findByIdMedico");
		query.setParameter("medico_id", id);
		return  new ArrayList<>(query.getResultList());
	}

	public void closeEmf() {
		em.close();
	}
	
	
	
	

}
