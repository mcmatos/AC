package org.academiadecodigo.asciimos.Controller;

import org.academiadecodigo.asciimos.model.Customer;
import org.academiadecodigo.asciimos.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(value = "/list")
    public String customerList(Model model) {

        Customer customer1 = new Customer();
        customer1.setEmail("asd");
        customer1.setFirstName("magno");
        customer1.setLastName("matos");
        customer1.setPhone("1234");
        customerService.listCostumers().add(customer1);

        System.out.println(customerService.listCostumers().size());
        model.addAttribute("customers", customerService.listCostumers());

        return "customerList";
    }

}
