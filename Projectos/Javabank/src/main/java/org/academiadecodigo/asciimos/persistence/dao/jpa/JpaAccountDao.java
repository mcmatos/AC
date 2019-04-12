package org.academiadecodigo.asciimos.persistence.dao.jpa;

import org.academiadecodigo.asciimos.model.account.Account;
import org.academiadecodigo.asciimos.persistence.dao.AccountDao;
import org.academiadecodigo.asciimos.persistence.jpa.JpaSessionManager;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

/**
 * A JPA {@link AccountDao} implementation
 */
@Repository
@Profile("jpa")
public class JpaAccountDao extends GenericJpaDao<Account> implements AccountDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(JpaSessionManager, Class)
     */
    public JpaAccountDao(JpaSessionManager sm) {
        super(sm, Account.class);
    }
}
