package ejbAgenda;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

public class RendezVous implements Serializable {


@Id
@GeneratedValue (strategy=GenerationType.AUTO)
	private int		id;
	private String	date;
	private String	heureDebut;
	private String	heureFin;
	private String	libelle;
	private Collection<Contact> Participants;
	
	public RendezVous(){}

	
	public RendezVous(int id, String date, String heureDebut, String heureFin, String libelle) {
		this.id = id;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.libelle = libelle;
	}
	
	
	@ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name="participer",
	joinColumns=@JoinColumn(name="rendezvous_id", referencedColumnName="id"),
	inverseJoinColumns=@JoinColumn(name="contact_id", referencedColumnName="id")
	)
	
	public Set<Contact> lesContacts = new HashSet<Contact>(); 
	
	public Set<Contact> getLesContacts() {
		return lesContacts;
	}
	public void setLesContacts(Set<Contact> lesContacts) {
		this.lesContacts = lesContacts;
	}

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(String heureFin) {
		this.heureFin = heureFin;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}


	public Collection<Contact> getParticipants() {
		return Participants;
	}


	public void setParticipants(Collection<Contact> participants) {
		Participants = participants;
	}
	
}
