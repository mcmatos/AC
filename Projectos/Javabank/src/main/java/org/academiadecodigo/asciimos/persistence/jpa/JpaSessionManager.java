package org.academiadecodigo.asciimos.persistence.jpa;

import org.academiadecodigo.asciimos.persistence.SessionManager;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * A JPA {@link SessionManager} implementation
 */
@Repository
@Profile("jpa")
public class JpaSessionManager implements SessionManager<EntityManager> {

    private EntityManagerFactory emf;
    private EntityManager em;

    /**
     * Initializes a new {@code JPA Session Manager} instance given an entity manager factory
     *
     * @param emf the entity manager factory
     */
    public JpaSessionManager(EntityManagerFactory emf) {
        this.emf = emf;
    }

    /**
     * @see SessionManager#startSession()
     */
    @Override
    public void startSession() {

        if (em == null) {
            em = emf.createEntityManager();
        }
    }

    /**
     * @see SessionManager#stopSession()
     */
    @Override
    public void stopSession() {

        if (em != null) {
            em.close();
        }

        em = null;
    }

    /**
     * @see SessionManager#getCurrentSession()
     */
    @Override
    public EntityManager getCurrentSession() {
        startSession();
        return em;
    }
}
