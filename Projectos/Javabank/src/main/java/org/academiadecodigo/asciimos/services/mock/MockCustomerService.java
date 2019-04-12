package org.academiadecodigo.asciimos.services.mock;

import org.academiadecodigo.asciimos.model.Customer;
import org.academiadecodigo.asciimos.model.Recipient;
import org.academiadecodigo.asciimos.model.account.Account;
import org.academiadecodigo.asciimos.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * A mock {@link CustomerService} implementation
 */
@Service
@Profile("test")
public class MockCustomerService extends AbstractMockService<Customer> implements CustomerService {

    private LinkedList<Customer> linkedList = new LinkedList<>();

    /**
     * @see CustomerService#get(Integer)
     */
    @Override
    public Customer get(Integer id) {
        return modelMap.get(id);
    }

    /**
     * @see CustomerService#getBalance(Integer)
     */
    @Override
    public double getBalance(Integer id) {

        List<Account> accounts = modelMap.get(id).getAccounts();

        double balance = 0;
        for (Account account : accounts) {
            balance += account.getBalance();
        }

        return balance;
    }

    /**
     * @see CustomerService#listCustomerAccountIds(Integer)
     */
    @Override
    public Set<Integer> listCustomerAccountIds(Integer id) {

        Set<Integer> accountIds = new HashSet<>();
        List<Account> accounts = modelMap.get(id).getAccounts();

        for (Account account : accounts) {
            accountIds.add(account.getId());
        }

        return accountIds;
    }

    /**
     * @see CustomerService#listRecipients(Integer)
     */
    @Override
    public List<Recipient> listRecipients(Integer id) {
        return modelMap.get(id).getRecipients();
    }

    @Override
    public List<Customer> listCostumers() {
        return linkedList;
    }
}
