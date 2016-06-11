package persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Paziente;

public class PazienteDao implements Dao<Paziente> {
	
	private EntityManager em;

	public PazienteDao(EntityManager em) {
		this.em = em;
	}

	public void save(Paziente c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public Paziente findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Paziente c = em.find(Paziente.class, id);
		tx.commit();
		return c;
	}
	public Paziente findByCodiceFiscale(String cf) {
		Query query =em.createNamedQuery("Paziente.findByCodiceFiscale");
		query.setParameter("codiceFiscale", cf);
		try {
			return (Paziente)query.getResultList().get(0);
		}catch(Exception exception){
			return null;}
	}
	
	public Paziente findByMail(String mail) {
		Query query =em.createNamedQuery("Paziente.findByMail");
		query.setParameter("mail", mail);
		try{
		return (Paziente)query.getResultList().get(0);
		}catch(Exception exception){
		return null;}
		
	}

	public void delete(Paziente c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Paziente toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Paziente c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Paziente> findAll() {
		
		return null;
	}

	public void closeEmf() {
		em.close();
	}
	
	

}
