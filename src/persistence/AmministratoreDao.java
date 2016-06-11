package persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Amministratore;


public class AmministratoreDao implements Dao<Amministratore>{
	private EntityManager em;

	public AmministratoreDao(EntityManager em) {
		this.em = em;
	}

	public void save(Amministratore c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public Amministratore findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Amministratore c = em.find(Amministratore.class, id);
		tx.commit();
		return c;
	}
	public long findIdByCodiceFiscale(String parameter) {
		return (long) em.createNamedQuery("Amministratore.findIdByCodiceFiscale").setParameter("codiceFiscale", parameter).getResultList().get(0);
		
	}

	public void delete(Amministratore c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Amministratore toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Amministratore c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Amministratore> findAll() {
		List<Amministratore> result = em.createNamedQuery("Amministratore.findAll").getResultList();
		return result;
	}

	public void closeEmf() {
		em.close();
	}

	public Amministratore findByMail(String mail) {
		Query query =em.createNamedQuery("Amministratore.findByMail");
		query.setParameter("mail", mail);
		return (Amministratore)query.getResultList().get(0);
	}
}






