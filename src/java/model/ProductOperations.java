package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ProductOperations {
    
    public static void createNewProduct(String name, int quantity, double price) {

        Product product = new Product(name, quantity, price);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            PreparedStatement st = conn.prepareStatement("INSERT INTO product (name,quantity,price) VALUES (?,?,?)");
            st.setString(1, product.getName());
            st.setString(2, String.valueOf(product.getQuantity()));
            st.setString(3, String.valueOf(product.getPrice()));
            st.execute();

            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID() AS product_id FROM product");
            rs.next();
            product.setId(Integer.valueOf(rs.getString("product_id")));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Product> allProducts() {
        Product product;

        List<Product> products = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            Statement st = conn.createStatement();
            st.executeQuery("SELECT * FROM product");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
                products.add(product);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return products;
    }

    public static Product selectProductById(String id) {
        Product product = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            PreparedStatement st = conn.prepareStatement("SELECT * FROM product WHERE product_id = ?");
            st.setString(1, id);
            st.executeQuery();
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                product = new Product(rs.getInt("product_id"), rs.getString("name"), rs.getInt("quantity"), rs.getDouble("price"));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return product;
    }

    public static void updateProduct(int id, String name, int quantity, double price) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            String query = "UPDATE product SET name='" + name + "',quantity='" + String.valueOf(quantity) + "',price='" + String.valueOf(price) + "' WHERE product_id = '" + String.valueOf(id) + "'";

            Statement st = conn.createStatement();
            st.execute(query);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void deleteProduct(String id) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            PreparedStatement st = conn.prepareStatement("DELETE FROM product WHERE product_id = ?");
            st.setString(1, id);
            st.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
}
