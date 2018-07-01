package ejbAgenda;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class RendezVousManager
 */
@Stateless
@LocalBean
public class RendezVousManager implements RendezVousManagerRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
    public RendezVousManager() {}
    
    @Override
    public RendezVous ajouterRendezVous(RendezVous rdv){
    	em.persist(rdv);
    	return rdv;
    }

   @Override
    public Collection<RendezVous> listerRendezVous() {
    	return em.createQuery("SELECT r FROM RendezVous r").getResultList();
    	
    }
    
    
}
