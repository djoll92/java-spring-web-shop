package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SaleOperations {
    
    public static void createNewSale(int cId, int pId, int quantity) {
        Product product = ProductOperations.selectProductById(String.valueOf(pId));
        Customer customer = CustomerOperations.selectCustomerById(String.valueOf(cId));
        Sale sale = new Sale(cId, pId, quantity);
        
        double total = quantity*product.getPrice();
        sale.setTotal(total);
        
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {
            
            PreparedStatement st = conn.prepareStatement("INSERT INTO sale (customer_id,product_id,quantity,total) VALUES (?,?,?,?)");
            st.setString(1, String.valueOf(cId));
            st.setString(2, String.valueOf(pId));
            st.setString(3, String.valueOf(quantity));
            st.setString(4, String.valueOf(total));
            st.execute();

            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID() AS sale_id FROM product");
            rs.next();
            sale.setId(Integer.valueOf(rs.getString("sale_id")));

            product.setQuantity(product.getQuantity()-quantity);
            ProductOperations.updateProduct(pId, product.getName(), product.getQuantity(), product.getPrice());
            
            customer.setTotal(customer.getTotal()+total);
            CustomerOperations.updateTotalSum(cId, customer.getTotal());
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}
