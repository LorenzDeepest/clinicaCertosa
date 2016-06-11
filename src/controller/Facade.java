package controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;

import model.Esame;
import model.Medico;
import model.Paziente;
import model.TipologiaEsame;
import persistence.PazienteDao;




public class Facade {

	private EntityManagerFactory entityManagerFactory;
	private EntityManager entityManager;

	public Facade() {
		this.entityManagerFactory = Persistence.createEntityManagerFactory("products-unit");
		this.entityManager = this.entityManagerFactory.createEntityManager();
	}
	public List<TipologiaEsame> aquisisciTipologieEsami(){
		return new controller.Helper().aquisisciTipologieEsami(this.entityManager);
	}

	public String autenticaAmministratore(HttpServletRequest request){
		return new controller.Helper().autenticaAmministratore(this.entityManager, request);
	}

	public String autenticaPaziente(HttpServletRequest request){
		return new controller.Helper().autenticaPaziente(this.entityManager, request);
	}

	public void close(){
		this.entityManager.close();
		this.entityManagerFactory.close();
	}
	public String creaEsame(HttpServletRequest request) {
		return new controller.Helper().creaEsame(this.entityManager,request);

	}
	public List<Esame> aquisisciEsamiPaziente(HttpServletRequest request) {
		return new Helper().aquisisciEsamiPaziente(this.entityManager, request);
	}
	public List<Esame> aquisisciEsamiMedico(HttpServletRequest request) {
		return new Helper().aquisisciEsamiMedico(request,this.entityManager);
	}
	public List<Medico> aquisisciListaMedici() {
		return new controller.Helper().aquisisciListMedici(this.entityManager);
	}
	public Paziente aquisisciPaziente(String mail) {
		return new PazienteDao(entityManager).findByMail(mail);
	}
	public void registra(HttpServletRequest request) {
		new Helper().registra(request, this.entityManager);
	}
	public Paziente aquisisciPazienteCF(String parameter) {
		// TODO Auto-generated method stub
		return new Helper().aquisisciPazienteCF(entityManager, parameter);
	}
	public Medico aquisisciMedicoCF(String parameter) {
		// TODO Auto-generated method stub
		return new Helper().aquisisciMedicoCF(entityManager, parameter);
	}


}
