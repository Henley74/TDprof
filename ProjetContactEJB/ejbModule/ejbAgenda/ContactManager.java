package ejbAgenda;

import java.util.Collection;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Session Bean implementation class ContactManager
 */
@Stateless
@LocalBean
public class ContactManager implements ContactManagerRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext
	EntityManager em;
	
	
    public ContactManager() {}
    
    @Override
    public Contact ajouterContact(Contact contact) {
    	em.persist(contact);
    	return contact;
    	}
    @Override
    public Collection<Contact> listerContact() {
    	// Vous pouvez aussi utiliser une named query définie dans l’entité (cf TD5)
    	return em.createQuery("SELECT c FROM Contact c").getResultList(); 
    }


}
