package spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.entity.Customer;
import spring.service.CustomerService;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

    List<Customer> theCustomers;

    @Autowired
    private CustomerService Customerservice;


    @PostConstruct
    public void loadData() {
        theCustomers = new ArrayList<>();

        theCustomers.add(new Customer("Marcin", "Rzepko", "rzepa1005@gmail.com"));
        theCustomers.add(new Customer("Lol", "Chuj", "Ciwdupe@wp.pl"));
        theCustomers.add(new Customer("Jan", "Kowalski", "kowalskilowcaszparek@o2.pl"));
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {


        return Customerservice.getCustomers();
    }

    @GetMapping("/customers/{customerid}")
    public Customer getCustomer(@PathVariable int customerid)
    {
        return theCustomers.get(customerid);
    }
}
