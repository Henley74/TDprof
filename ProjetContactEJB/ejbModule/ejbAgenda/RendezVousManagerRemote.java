package ejbAgenda;

import java.util.Collection;

import javax.ejb.Remote;

@Remote
public interface RendezVousManagerRemote {
	RendezVous ajouterRendezVous(RendezVous rdv);
	Collection<RendezVous> listerRendezVous();
}
