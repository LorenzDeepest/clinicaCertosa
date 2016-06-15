package model;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity

@NamedQueries({
	@NamedQuery(name = "TipologiaEsame.findAll", query = "select distinct c from TipologiaEsame c"),
	@NamedQuery(name = "TipologiaEsame.findByName", query = "select distinct c from TipologiaEsame c where c.nome = :nome")
	})
public class TipologiaEsame {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false,unique=true)
	private String nome;
	
	@Column(nullable = false)
	private String descrizione;
	
	@Column(nullable = false)
	private float costo;
	
	@ManyToMany(fetch = FetchType.EAGER)
	
	private List<Prerequisito> prerequisiti;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Indicatore> indicatori;

	
	
	@Override
	public String toString() {
		return "TipologiaEsame [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", costo=" + costo
				+ ", prerequisiti=" + prerequisiti + ", indicatori=" + indicatori + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(costo);
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
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
		TipologiaEsame other = (TipologiaEsame) obj;
		if (Float.floatToIntBits(costo) != Float.floatToIntBits(other.costo))
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	public TipologiaEsame(){
		this.prerequisiti = new LinkedList<>();
		this.indicatori = new LinkedList<>();
	}
	public TipologiaEsame(String nome, String descrizione, float costo) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
		this.costo = costo;
		this.prerequisiti = new LinkedList<>();
		this.indicatori = new LinkedList<>();
	}

	//utility
	public void addPrerequisito(Prerequisito prerequisito) {
		this.prerequisiti.add(prerequisito);
	}
	public void addIndicatore(Indicatore indicatore) {
		this.indicatori.add(indicatore);
	}


	//getter and setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public List<Prerequisito> getPrerequisiti() {
		return prerequisiti;
	}

	public void setPrerequisiti(List<Prerequisito> prerequisiti) {
		this.prerequisiti = prerequisiti;
	}

	public List<Indicatore> getIndicatori() {
		return indicatori;
	}

	public void setIndicatori(List<Indicatore> indicatori) {
		this.indicatori = indicatori;
	}





}
