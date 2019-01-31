package controller;

import model.Product;
import model.ProductOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductsController {
    
    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String viewProducts(@RequestParam(value = "id", required = false, defaultValue = "0") int id, ModelMap model) {
        if (id>0){
            ProductOperations.deleteProduct(String.valueOf(id));
        }
        model.addAttribute("products", ProductOperations.allProducts());
        return "products";
    }

    @RequestMapping(value = "/new_product", method = RequestMethod.GET)
    public String newProductForm(ModelMap model) {
        model.addAttribute("product", new Product());
        return "new_product";
    }

    @RequestMapping(value = "/new_product", method = RequestMethod.POST)
    public String submitNewProduct(@ModelAttribute("product") Product product, ModelMap model) {
        ProductOperations.createNewProduct(product.getName(), product.getQuantity(), product.getPrice());
        viewProducts(0,model);
        return "products";
    }

    @RequestMapping(value = "/edit_product", method = RequestMethod.GET)
    public String editProduct(@RequestParam("id") String id, ModelMap model) {
        Product product = ProductOperations.selectProductById(id);
        model.addAttribute("product", product);
        return "edit_product";
    }

    @RequestMapping(value = "/edit_product", method = RequestMethod.POST)
    public String submitEditedProduct(@RequestParam("id") String id, @ModelAttribute("product") Product product, ModelMap model) {
        ProductOperations.updateProduct(Integer.valueOf(id), product.getName(), product.getQuantity(), product.getPrice());
        viewProducts(0,model);
        return "products";
    }

    
}
