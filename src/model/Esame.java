package model;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity(name="esame")
//@NamedQuery(name = "Esame.findByPaziente", query = "select distinct c from esame c where c.paziente_id = :id")
public class Esame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false)
	private Date dataPrenotazione;
	
	@Column(nullable = false)
	private Date dataEsame;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private Medico medico;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private TipologiaEsame tipologiaEsame;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "esame_id")
	private List<Risultato> risultati;
	
	
	public Esame(){}
	public Esame(Date dataPrenotazione, Date dataEsame, Medico medico, TipologiaEsame tipologiaEsame) {
		super();
		this.dataPrenotazione = dataPrenotazione;
		this.dataEsame = dataEsame;
		this.medico = medico;
		this.tipologiaEsame = tipologiaEsame;
		this.risultati = new LinkedList<>();
	}
	
	//utility
	public void addRisultato(Risultato risultato) {
		this.risultati.add(risultato);
	}
	
	//getter and setter
	public List<Risultato> getRisultati() {
		return risultati;
	}

	public void setRisultati(List<Risultato> risultati) {
		this.risultati = risultati;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public Date getDataEsame() {
		return dataEsame;
	}
	public void setDataEsame(Date dataEsame) {
		this.dataEsame = dataEsame;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public TipologiaEsame getTipologiaEsame() {
		return tipologiaEsame;
	}
	public void setTipologiaEsame(TipologiaEsame tipologiaEsame) {
		this.tipologiaEsame = tipologiaEsame;
	}
	//toString equals hashCode
	
	
	@Override
	public String toString() {
		return "Esame [id=" + id + ", dataPrenotazione=" + dataPrenotazione + ", dataEsame=" + dataEsame + ", medico="
				+ medico + ", tipologiaEsame=" + tipologiaEsame + ", risultati=" + risultati + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataEsame == null) ? 0 : dataEsame.hashCode());
		result = prime * result + ((dataPrenotazione == null) ? 0 : dataPrenotazione.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((medico == null) ? 0 : medico.hashCode());
		result = prime * result + ((risultati == null) ? 0 : risultati.hashCode());
		result = prime * result + ((tipologiaEsame == null) ? 0 : tipologiaEsame.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Esame other = (Esame) obj;
		if (dataEsame == null) {
			if (other.dataEsame != null)
				return false;
		} else if (!dataEsame.equals(other.dataEsame))
			return false;
		if (dataPrenotazione == null) {
			if (other.dataPrenotazione != null)
				return false;
		} else if (!dataPrenotazione.equals(other.dataPrenotazione))
			return false;
		if (id != other.id)
			return false;
		if (medico == null) {
			if (other.medico != null)
				return false;
		} else if (!medico.equals(other.medico))
			return false;
		if (risultati == null) {
			if (other.risultati != null)
				return false;
		} else if (!risultati.equals(other.risultati))
			return false;
		if (tipologiaEsame == null) {
			if (other.tipologiaEsame != null)
				return false;
		} else if (!tipologiaEsame.equals(other.tipologiaEsame))
			return false;
		return true;
	}
	
	


}
