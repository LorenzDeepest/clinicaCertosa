package model;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.Helper;
import persistence.AmministratoreDao;
import persistence.EsameDao;
import persistence.MedicoDao;
import persistence.PazienteDao;

public class Main {

	public static void main(String[] args) {
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("products-unit");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		//Medico medico  = new MedicoDao(entityManager).findById(1);
		
		//String s = "dott "+medico.getNome()+" "+medico.getCognome()+" "+medico.getEmail();
//		String uno = s.substring(0, s.indexOf(':')-1);
//		String due = s.substring(s.indexOf(':')+2);

		//String mail = s.substring(s.lastIndexOf(" ")+1);
//		Medico medicoCorrente = new Helper().getMedicoCorrente(mail, entityManager);
		
//		System.out.println(medicoCorrente.toString());
		Paziente paziente = new PazienteDao(entityManager).findById(10);
		Medico medico=new MedicoDao(entityManager).findById(1);
		System.out.println(medico.getEsamiEffettuati());
	}

}
