package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Risultato {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable=false,unique=true)
	private String name;
	
	@Column(nullable=false)
	private String valore;

	
	public Risultato(){}
		
	
	public Risultato(String name, String descrizione) {
		super();
		this.name = name;
		this.valore = descrizione;
	}

	//getter and setter
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValore() {
		return valore;
	}

	public void setValore(String descrizione) {
		this.valore = descrizione;
	}
	
	
	
	

}
