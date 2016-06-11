package persistence;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Esame;


public class EsameDao implements Dao<Esame> {
	private EntityManager em;

	public EsameDao(EntityManager em) {
		this.em = em;
	}

	public void save(Esame o) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(o);
		tx.commit();
	}

	public Esame findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Esame c = em.find(Esame.class, id);
		tx.commit();
		return c;
	}

	public void delete(Esame o) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Esame toRemove = em.merge(o);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(Esame o) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(o);
		tx.commit();
	}

	
//	@SuppressWarnings("unchecked")
//	public List<Esame> findByPaziente(long id){
//		Query query =em.createNamedQuery("Esame.findByPaziente");
//		query.setParameter("id", id);
//		return new ArrayList<>(query.getResultList());
//	}

	@Override
	public List<Esame> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	
	


}
