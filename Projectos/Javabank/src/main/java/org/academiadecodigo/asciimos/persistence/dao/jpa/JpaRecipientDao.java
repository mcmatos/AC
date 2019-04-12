package org.academiadecodigo.asciimos.persistence.dao.jpa;

import org.academiadecodigo.asciimos.model.Recipient;
import org.academiadecodigo.asciimos.persistence.dao.RecipientDao;
import org.academiadecodigo.asciimos.persistence.jpa.JpaSessionManager;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link RecipientDao} implementation
 */
@Repository
@Profile("jpa")
public class JpaRecipientDao extends GenericJpaDao<Recipient> implements RecipientDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(JpaSessionManager, Class)
     */
    public JpaRecipientDao(JpaSessionManager sm) {
        super(sm, Recipient.class);
    }
}
