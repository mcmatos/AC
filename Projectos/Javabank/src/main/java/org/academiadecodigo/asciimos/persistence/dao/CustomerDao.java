package org.academiadecodigo.asciimos.persistence.dao;


import org.academiadecodigo.asciimos.model.Customer;

import java.util.List;

/**
 * Common interface for customer data access objects
 */
public interface CustomerDao extends Dao<Customer> {

    /**
     * Gets a list of customer ids
     *
     * @return the list of customer ids
     */
    List<Integer> getCustomerIds();
}
