package org.academiadecodigo.bootcamp22;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {

    @GetMapping(value = "/hi")
    public String sayHi(Model model) {
        model.addAttribute("greeting", "Hey");
        model.addAttribute("customerDetails", new Customer("magno", "matos", 29));
        return "greeting";
    }
}