package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Clinica {

	
	private List<TipologiaEsame> tipologieEsami;
	private Map<String,Paziente> pazienti;
	private Map<String,Medico> medici;
	private Map<String,Amministratore> amministratori;

	
	private Portale portale;


	public Clinica() {
		super();
		this.tipologieEsami = new LinkedList<>();
		this.pazienti = new HashMap<>();
		this.medici = new HashMap<>();
		this.amministratori = new HashMap<>();
		this.portale = new Portale(this);
	}
	//utility
	public void addTipologiaEsame(TipologiaEsame tipologiaEsame){
		this.tipologieEsami.add(tipologiaEsame);		
	}
	//gettre and setter

	public List<TipologiaEsame> getTipologieEsami() {
		return tipologieEsami;
	}


	public void setTipologieEsami(List<TipologiaEsame> tipologieEsami) {
		this.tipologieEsami = tipologieEsami;
	}

	public Portale getPortale() {
		return portale;
	}


	public void setPortale(Portale portale) {
		this.portale = portale;
	}
	public Map<String,Amministratore> getAmministratori() {
		return amministratori;
	}
	public void setAmministratori(Map<String,Amministratore> amministratori) {
		this.amministratori = amministratori;
	}
	public Map<String,Medico> getMedici() {
		return medici;
	}
	public void setMedici(Map<String,Medico> medici) {
		this.medici = medici;
	}
	public Map<String,Paziente> getPazienti() {
		return pazienti;
	}
	public void setPazienti(Map<String,Paziente> pazienti) {
		this.pazienti = pazienti;
	}







}
