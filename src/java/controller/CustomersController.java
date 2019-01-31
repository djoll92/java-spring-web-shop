package controller;

import model.Customer;
import model.CustomerOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CustomersController {

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public String viewCustomers(@RequestParam(value = "id", required = false, defaultValue = "0") int id, ModelMap model) {
        if (id>0){
            CustomerOperations.deleteCustomer(String.valueOf(id));
        }
        model.addAttribute("customers", CustomerOperations.allCustomers());
        return "customers";
    }

    @RequestMapping(value = "/new_customer", method = RequestMethod.GET)
    public String newCustomerForm(ModelMap model) {
        model.addAttribute("customer", new Customer());
        return "new_customer";
    }

    @RequestMapping(value = "/new_customer", method = RequestMethod.POST)
    public String submitNewCustomer(@ModelAttribute("customer") Customer customer, ModelMap model) {
        CustomerOperations.createNewCustomer(customer.getName(), customer.getEmail());
        viewCustomers(0,model);
        return "/customers";
    }

    @RequestMapping(value = "/edit_customer", method = RequestMethod.GET)
    public String editCustomer(@RequestParam("id") String id, ModelMap model) {
        Customer customer = CustomerOperations.selectCustomerById(id);
        model.addAttribute("customer", customer);
        return "edit_customer";
    }

    @RequestMapping(value = "/edit_customer", method = RequestMethod.POST)
    public String submitEditedCustomer(@RequestParam("id") String id, @ModelAttribute("customer") Customer customer, ModelMap model) {
        CustomerOperations.updateCustomer(Integer.valueOf(id), customer.getName(), customer.getEmail());
        viewCustomers(0,model);
        return "customers";
    }

}
