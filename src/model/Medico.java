package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name="medico")
@NamedQueries({
	@NamedQuery(name = "Medico.findAll", query = "select distinct c from medico c "),
	@NamedQuery(name = "Medico.findByMail", query = "select distinct c from medico c where c.email = :email"),
	@NamedQuery(name = "Medico.findByCodiceFiscale", query = "select distinct c from medico c where c.codiceFiscale = :codiceFiscale")

	})

public class Medico {

	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String cognome;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(nullable = false)
	private String password;

	@Column(unique = true, nullable = false)
	private String email;

	@Column(unique = true, nullable = false)
	private String codiceFiscale;

	@Temporal(TemporalType.DATE)
	private Date dataDiNascita;

	@ManyToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	private List<Specializzazione> specializzazioni;

	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE})
	@JoinColumn(name = "medico_id")
	private List<Esame> esamiEffettuati;


	//costruttori
	public Medico(String nome, String cognome, String password, String email, String codiceFiscale,
			Date dataDiNascita) {
		this.nome = nome;
		this.cognome = cognome;
		this.password = password;
		this.email = email;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
	}
	public Medico(){}

	//getter and setter
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public boolean verificaPassword(String password) {
		return this.password == password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public Date getDataDiNascita() {
		return dataDiNascita;
	}
	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}
	public void setEsamiEffettuati(List<Esame> esamiEffettuati) {
		this.esamiEffettuati = esamiEffettuati;
	}

	public void setSpecializzazioni(List<Specializzazione> specializzazioni) {
		this.specializzazioni = specializzazioni;
	}

	public List<Specializzazione> getSpecializzazioni() {
		return specializzazioni;
	}


	//utility
	public void addSpecializzazione(Specializzazione specializzazione) {
		this.specializzazioni.add(specializzazione);
	}
	public void addEsameEffettuato(Esame esameEffettuato) {
		this.esamiEffettuati.add(esameEffettuato);
	}

	//getter and setter
	public List<Esame> getEsamiEffettuati() {
		return esamiEffettuati;
	}


//toùstring hashcode equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Medico other = (Medico) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Medico [nome=" + nome + ", cognome=" + cognome + ", email=" + email + ", codiceFiscale=" + codiceFiscale
				+ ", dataDiNascita=" + dataDiNascita + "]";
	}




}
