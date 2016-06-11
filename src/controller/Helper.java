package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.routines.DateValidator;

import model.Amministratore;
import model.Esame;
import model.Medico;
import model.Paziente;
import model.TipologiaEsame;
import persistence.AmministratoreDao;
import persistence.MedicoDao;
import persistence.PazienteDao;
import persistence.TipologiaEsameDao;

public class Helper {


	public List<TipologiaEsame> aquisisciTipologieEsami(EntityManager em){
		TipologiaEsameDao tipologiaEsameDao = new TipologiaEsameDao(em);
		return new ArrayList<>(tipologiaEsameDao.findAll());
	}

	public Amministratore aquisisciAmministratore(EntityManager em, String mail){
		AmministratoreDao amministratoreDao = new AmministratoreDao(em);
		return amministratoreDao.findByMail(mail);

	}
	public Paziente aquisisciPaziente(EntityManager em, String mail){
		PazienteDao pazienteDao = new PazienteDao(em);
		return pazienteDao.findByMail(mail);

	}
	public Paziente aquisisciPazienteCF(EntityManager em, String cf){
		PazienteDao pazienteDao = new PazienteDao(em);
		return pazienteDao.findByCodiceFiscale(cf);

	}

	public String autenticaAmministratore(EntityManager em, HttpServletRequest request){
		if(validateAutenticazione(request)){
			try{
				String mail = (String)request.getParameter("id");
				Amministratore amministratore = aquisisciAmministratore(em, mail);

				if (amministratore==null){
					request.setAttribute("erroreUsername", "non è stato trovato un amministratore "
							+ "associato alla mail inserita");
					return "/loginAmministratore.jsp";
				}
				else if(amministratore.verificaPassword(request.getParameter("password"))){
					request.getSession().setAttribute("amministratoreCorrente", amministratore);
					return "/paginaAmministrazione.jsp";				}
				else {
					request.setAttribute("errorePassword", "password inserita non valida");
					return "/loginAmministratore.jsp";
				}
			}
			catch(Exception e){
				request.setAttribute("erroreUsername", "non è stato trovato un amministratore "
						+ "associato alla mail inserita");
				return "/loginAmministratore.jsp";
			}
		}
		else return "/loginAmministratore.jsp";
	}
	public String autenticaPaziente(EntityManager em, HttpServletRequest request){
		if(validateAutenticazione(request)){
			try{
				String mail = (request.getParameter("id"));
				Paziente paziente = aquisisciPaziente(em, mail);

				if (paziente==null){
					request.setAttribute("erroreUsername", "non è stato trovato un paziente "
							+ "associato alla mail inserita");
					return "/home.jsp";
				}
				else if(paziente.verificaPassword(request.getParameter("password"))){
					request.getSession().setAttribute("pazienteCorrente", paziente);
					return "/areaPaziente.jsp";
				}
				else {
					request.setAttribute("errorePassword", "password inserita non valida");
					return "/home.jsp";
				}
			}
			catch(Exception e){
				request.setAttribute("erroreUsername", "non è stato trovato un amministratore "
						+ "associato al'id inserito");
				return "/home.jsp";
			}
		}
		else return "/home.jsp";
	}


	public boolean validateAutenticazione(HttpServletRequest request) {

		boolean corretto=true;
		String password = request.getParameter("password");
		String id = request.getParameter("id");
		if(id.equals("")){
			corretto = false;
			request.setAttribute("idError","id: campo obligatorio");			
		}
		if(password.equals("")){
			request.setAttribute("passwordError","password: campo obligatorio");	
			corretto = false;
		}
		return corretto;
	}

	public String creaEsame(EntityManager em,HttpServletRequest request) {
		PazienteDao pazienteDao = new PazienteDao(em);
		MedicoDao medicoDao = new MedicoDao(em);
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Paziente paziente = pazienteDao.findByCodiceFiscale(request.getParameter("paziente"));
		Medico medico = medicoDao.findByCodiceFiscale(request.getParameter("medico"));
		tx.commit();
		

		if(medico==null){
			request.setAttribute("erroreMedico","il codice fiscale inserito non è associato a nessun medico della clinica.");
			return "/creaEsame.jsp";
		}
		if(paziente==null){
			request.setAttribute("errorePaziente","il codice fiscale inserito non è associato a nessun paziente della clinica.");
			return "/creaEsame.jsp";
		}
		Calendar calendarPrenotazione = Calendar.getInstance();
		Date dataPrenotazione = calendarPrenotazione.getTime();
		Date dataEsame = prendiDataEsame(request);
		TipologiaEsame tipologiaEsame = new TipologiaEsameDao(em).findByName(request.getParameter("tipologiaEsame"));
		Esame nuovoEsame=new Esame(dataPrenotazione,dataEsame,medico,tipologiaEsame);
		paziente.addEsame(nuovoEsame);
		medico.addEsameEffettuato(nuovoEsame);//effettuare questo dopo che l'esame è stato effettuato?

		tx = em.getTransaction();
		tx.begin();
		pazienteDao.update(paziente);
		medicoDao.update(medico);
		tx.commit();
		if(request.getParameter("finito").equals("finito"))
			return "/paginaAmministrazione.jsp";
		return "/creaEsame.jsp";
	}
	public Date prendiDataEsame(HttpServletRequest request){
		String data = request.getParameter("data");
		String orario = request.getParameter("ora");

		int anno = new Integer(data.substring(6,10));
		int mese = new Integer(data.substring(3,5));
		int giorno = new Integer(data.substring(0, 2));
		int ora = new Integer(orario.substring(0, 2));
		int minuto = new Integer(orario.substring(3,5));
		Calendar cal = Calendar.getInstance();
		cal.set(anno, mese, giorno, ora, minuto, 0);
		return cal.getTime();

	}

	public List<Esame> aquisisciEsamiPaziente(EntityManager entityManager, HttpServletRequest request) {
		Paziente paziente = (Paziente) request.getSession().getAttribute("pazienteCorrente");
		return new ArrayList<>(paziente.getEsami());
	}

	public List<Esame> aquisisciEsamiMedico(HttpServletRequest request,EntityManager em) {
		Medico medico = getMedicoCorrente(request);
		return new ArrayList<>(medico.getEsamiEffettuati());
	}

	@SuppressWarnings("unchecked")
	public Medico getMedicoCorrente(HttpServletRequest request){
		String nomeMedico =  request.getParameter("nomeMedico");
		String mail = nomeMedico.substring(nomeMedico.lastIndexOf(" ")+1);
		List<Medico> medici = (List<Medico>) request.getSession().getAttribute("medici");
		for(Medico medico : medici){
			if(medico.getEmail().equals(mail)){
				return medico;
			}
		}
		return null;
	}

	public List<Medico> aquisisciListMedici(EntityManager entityManager) {
		return new ArrayList<>(new MedicoDao(entityManager).findAll());
	}
	
	public boolean validateRegistrazione(HttpServletRequest request) {
		
		String nome,cognome,dataDiNascita, codiceFiscale,password, mail;
		boolean corretto = true;
		nome = request.getParameter("nome");
		cognome = request.getParameter("cognome");
		dataDiNascita = request.getParameter("dataDiNascita");
		codiceFiscale = request.getParameter("codiceFiscale");
		password = request.getParameter("password");
		mail = request.getParameter("mail");
		
		if(nome.equals("")){
			corretto = false;
			request.setAttribute("nomeError","nome: campo obligatorio");		
		}
		if(cognome.equals("")){
			corretto = false;
			request.setAttribute("cognomeError","cognome: campo obligatorio");
			
		}
		if(codiceFiscale.equals("")){
			corretto = false;
			request.setAttribute("codiceFiscaleError","codiceFiscale: campo obligatorio");			
		}
		
		if(dataDiNascita.equals("")){
			corretto = false;
			request.setAttribute("dataDiNascitaError","dataDiNascita: campo obligatorio");						
		}
		DateValidator dateValidator = new DateValidator();
		if(dateValidator.validate(dataDiNascita) == null){
			corretto = false;
			request.setAttribute("dataDiNascitaError","dataDiNascita non valida");
		}
		
		if(password.equals("")){
			corretto = false;
			request.setAttribute("passwordError","password: campo obligatorio");			
		}
		Pattern pattern = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#!?:$%]).{6,20})");
		Matcher matcher = pattern.matcher(password);
		if(!matcher.matches()){
			corretto = false;
			request.setAttribute("passwordError","password: non valida");
		}
		
		
		if(!request.getParameter("password2").equals(password)){
			corretto = false;
			request.setAttribute("passwordError","le password non coincidono");		
		}
		
		if(mail.equals("")){
			corretto = false;
			request.setAttribute("mailError","mail: campo obligatorio");			
		}
		pattern = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
		matcher = pattern.matcher(mail);
		if(!matcher.matches()){
			corretto = false;
			request.setAttribute("mailError","mail: non valida");
		}
		if(new Facade().aquisisciPaziente(mail) != null){
			corretto = false;
			request.setAttribute("mailError","mail: utente già registrato");
		}
	
		if(!request.getParameter("mail2").equals(mail)){
			corretto = false;
			request.setAttribute("mailError","le mail non coincidono");			
		}
		return corretto;
	}

	public void registra(HttpServletRequest request, EntityManager em) {
		Paziente paziente = new Paziente();
		
		paziente.setCognome(request.getParameter("cognome"));
		paziente.setNome(request.getParameter("nome"));
		paziente.setDataDiNascita(new DateValidator().validate(request.getParameter("dataDiNascita")));	
		paziente.setCodiceFiscale(request.getParameter("codiceFiscale"));
		paziente.setEmail(request.getParameter("mail"));
		paziente.setPassword(request.getParameter("password"));
		new PazienteDao(em).save(paziente);
		request.getSession().setAttribute("utente", paziente);
		
		}

	public Medico aquisisciMedicoCF(EntityManager entityManager, String parameter) {
			MedicoDao medicoDao = new MedicoDao(entityManager);
			return medicoDao.findByCodiceFiscale(parameter);

		}
	


}
