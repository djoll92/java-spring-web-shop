package controller;

import model.Sale;
import model.CustomerOperations;
import model.Product;
import model.ProductOperations;
import model.SaleOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SalesController {
    
    @RequestMapping(value = "/new_sale", method = RequestMethod.GET)
    public String newSale(@RequestParam(value = "message", required = false, defaultValue = "") String message, ModelMap model) {
        model.addAttribute("customers", CustomerOperations.allCustomers());
        model.addAttribute("products", ProductOperations.allProducts());
        model.addAttribute("sale", new Sale());
        model.addAttribute("message", message);
        return "new_sale";
    }
    
    @RequestMapping(value = "/new_sale", method = RequestMethod.POST)
    public String submitSale(@ModelAttribute("sale") Sale sale, ModelMap model) {
        Product product = ProductOperations.selectProductById(String.valueOf(sale.getProductId()));
        String message = "";
        
        if (sale.getQuantity() <= product.getQuantity()){
            
        SaleOperations.createNewSale(sale.getCustomerId(), sale.getProductId(), sale.getQuantity());
        
        } else {
            
            message = "Sorry, current quantitative state of selected product is only "+product.getQuantity()+ " unit(s).";
        }
        
        newSale(message, model);
        return "new_sale";
    }
    
}
