package persistence;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Medico;

public class MedicoDao implements Dao<Medico> {

	private EntityManager em;

	public MedicoDao(EntityManager em) {
		this.em = em;
	}

	public void save(Medico c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public Medico findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Medico c = em.find(Medico.class, id);
		tx.commit();
		return c;
	}

	public void delete(Medico c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Medico toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Medico c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<Medico> findAll() {
		List<Medico> result = em.createNamedQuery("Medico.findAll").getResultList();
		return result;
	}

	public void closeEmf() {
		em.close();
	}

	public Medico findByCodiceFiscale(String parameter) {
		try{
			Query query =em.createNamedQuery("Medico.findByCodiceFiscale");
		query.setParameter("codiceFiscale", parameter);
		return (Medico)query.getResultList().get(0);
		}catch(Exception exception){
			return null;
		}
	}


	public Medico findByMail(String email) {
		Query query =em.createNamedQuery("Medico.findByMail");
		query.setParameter("email", email);
		return (Medico)query.getResultList().get(0);
	}


}
