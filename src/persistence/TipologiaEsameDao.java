package persistence;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Medico;
import model.TipologiaEsame;

public class TipologiaEsameDao implements Dao<TipologiaEsame> {


	private EntityManager em;

	public TipologiaEsameDao(EntityManager em) {
		this.em = em;
	}

	public void save(TipologiaEsame c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(c);
		tx.commit();
	}

	public TipologiaEsame findById(long id) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TipologiaEsame c = em.find(TipologiaEsame.class, id);
		tx.commit();
		return c;
	}

	public void delete(TipologiaEsame c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		TipologiaEsame toRemove = em.merge(c);
		em.remove(toRemove);
		tx.commit();		
	}

	public void update(TipologiaEsame c) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(c);
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	public List<TipologiaEsame> findAll() {
		List<TipologiaEsame> result =  new ArrayList<>(em.createNamedQuery("TipologiaEsame.findAll").getResultList());
		return result;
	}

	public void closeEmf() {
		em.close();
	}

	public TipologiaEsame findByName(String parameter) {
		try{
			Query query =em.createNamedQuery("TipologiaEsame.findByName");
			query.setParameter("nome", parameter);
			return (TipologiaEsame)query.getResultList().get(0);
		}catch(Exception exception){
			return null;
		}
	}




}