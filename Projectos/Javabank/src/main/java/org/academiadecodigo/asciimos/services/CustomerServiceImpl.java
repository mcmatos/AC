package org.academiadecodigo.asciimos.services;

import org.academiadecodigo.asciimos.model.Customer;
import org.academiadecodigo.asciimos.model.Recipient;
import org.academiadecodigo.asciimos.model.account.Account;
import org.academiadecodigo.asciimos.persistence.dao.CustomerDao;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * An {@link CustomerService} implementation
 */
@Service
@Profile("jpa")
public class CustomerServiceImpl implements CustomerService {

    private CustomerDao customerDao;

    /**
     * Sets the customer data access object
     *
     * @param customerDao the account DAO to set
     */
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    /**
     * @see CustomerService#get(Integer)
     */
    @Transactional
    @Override
    public Customer get(Integer id) {

            return customerDao.findById(id);

    }

    /**
     * @see CustomerService#getBalance(Integer)
     */
    @Transactional
    @Override
    public double getBalance(Integer id) {

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            List<Account> accounts = customer.getAccounts();

            double balance = 0;
            for (Account account : accounts) {
                balance += account.getBalance();
            }

            return balance;
    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Transactional
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

            Customer customer = customerDao.findById(id);

            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            Set<Integer> accountIds = new HashSet<>();
            List<Account> accounts = customer.getAccounts();

            for (Account account : accounts) {
                accountIds.add(account.getId());
            }

            return accountIds;
    }

    /**
     * @see CustomerService#listRecipients(Integer)
     */
    @Transactional
    @Override
    public List<Recipient> listRecipients(Integer id) {


            Customer customer = customerDao.findById(id);
            if (customer == null) {
                throw new IllegalArgumentException("Customer does not exists");
            }

            return new ArrayList<>(customerDao.findById(id).getRecipients());

    }

    @Override
    public List<Customer> listCostumers() {
        return null;
    }
}
