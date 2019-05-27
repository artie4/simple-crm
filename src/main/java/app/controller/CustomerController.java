package app.controller;

import app.model.Customer;
import app.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    // inject customer app.service
    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model theModel) {

        // get customers from app.dao
         List<Customer> theCustomers = customerService.getCustomers();

        // add the customers to the app.model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create app.model attribute to bind form data
        Customer theCustomer = new Customer();

        theModel.addAttribute("customer", theCustomer);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {

        customerService.saveCustomer(theCustomer);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") UUID theId, Model theModel) {


        // get the customer from a app.service
        Customer theCustomer = customerService.getCustomer(theId);

        // set customer as a app.model attribute to pre-populate the form
        theModel.addAttribute("customer", theCustomer);

        // send over to our form
        return "customer-form";

    }

    @GetMapping("/delete")
    public String deleteCustomer(@RequestParam("customerId") UUID theId) {

        // delete customer by id
        customerService.deleteCustomer(theId);

        return "redirect:/customer/list";
    }

    @GetMapping("/search")
    public String searchCustomers(
            @RequestParam("theSearchName") String theSearchName, Model theModel) {

        // search customers from the app.service
        List<Customer> theCustomers = customerService.searchCustomers(theSearchName);

        // add the customers to the app.model
        theModel.addAttribute("customers", theCustomers);

        return "list-customers";

    }
}
