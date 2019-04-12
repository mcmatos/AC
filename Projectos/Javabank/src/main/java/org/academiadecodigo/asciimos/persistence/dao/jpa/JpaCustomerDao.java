package org.academiadecodigo.asciimos.persistence.dao.jpa;

import org.academiadecodigo.asciimos.model.Customer;
import org.academiadecodigo.asciimos.persistence.TransactionException;
import org.academiadecodigo.asciimos.persistence.dao.CustomerDao;
import org.academiadecodigo.asciimos.persistence.jpa.JpaSessionManager;
import org.hibernate.HibernateException;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * A JPA {@link CustomerDao} implementation
 */
@Repository
@Profile("jpa")
public class JpaCustomerDao extends GenericJpaDao<Customer> implements CustomerDao {

    /**
     * @see GenericJpaDao#GenericJpaDao(JpaSessionManager, Class)
     */
    public JpaCustomerDao(JpaSessionManager sm) {
        super(sm, Customer.class);
    }

    /**
     * @see CustomerDao#getCustomerIds()
     */
    public List<Integer> getCustomerIds() {
        try {

            EntityManager em = sm.getCurrentSession();
            return em.createQuery("select id from Customer", Integer.class)
                    .getResultList();

        } catch (HibernateException ex) {
            throw new TransactionException(ex);
        }
    }
}
