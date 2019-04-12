package org.academiadecodigo.asciimos.services;


import org.academiadecodigo.asciimos.model.Customer;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

/**
 * An {@link AuthService} implementation
 */
@Service
@Profile("jpa")
public class AuthServiceImpl implements AuthService {

    private CustomerService customerService;
    private Integer accessingCustomerId;

    /**
     * Sets the customer service
     *
     * @param customerService the customer service to set
     */
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    /**
     * @see AuthService#authenticate(Integer)
     */
    @Override
    public boolean authenticate(Integer id) {

        Customer customer = customerService.get(id);

        if (customer == null) {
            return false;
        }

        accessingCustomerId = customer.getId();
        return true;
    }

    /**
     * @see AuthService#getAccessingCustomer()
     */
    @Override
    public Customer getAccessingCustomer() {
        return customerService.get(accessingCustomerId);
    }
}
