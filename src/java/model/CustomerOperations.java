package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerOperations {

    public static void createNewCustomer(String name, String email) {

        Customer customer = new Customer(name, email);

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            PreparedStatement st = conn.prepareStatement("INSERT INTO customer (name,email,total) VALUES (?,?,?)");
            st.setString(1, customer.getName());
            st.setString(2, customer.getEmail());
            st.setString(3, String.valueOf(customer.getTotal()));
            st.execute();

            ResultSet rs = st.executeQuery("SELECT LAST_INSERT_ID() AS customer_id FROM customer");
            rs.next();
            customer.setId(Integer.valueOf(rs.getString("customer_id")));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Customer> allCustomers() {
        Customer customer;

        List<Customer> customers = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            Statement st = conn.createStatement();
            st.executeQuery("SELECT * FROM customer");
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                customer = new Customer(rs.getInt("customer_id"), rs.getString("name"), rs.getString("email"), rs.getDouble("total"));
                customers.add(customer);
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return customers;
    }

    public static Customer selectCustomerById(String id) {
        Customer customer = null;

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            PreparedStatement st = conn.prepareStatement("SELECT * FROM customer WHERE customer_id = ?");
            st.setString(1, id);
            st.executeQuery();
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                customer = new Customer(rs.getInt("customer_id"), rs.getString("name"), rs.getString("email"), rs.getDouble("total"));
            }

        } catch (Exception ex) {
            System.out.println(ex);
        }

        return customer;
    }

    public static void updateCustomer(int id, String name, String email) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            String query = "UPDATE customer SET name='" + name + "',email='" + email + "' WHERE customer_id = '" + String.valueOf(id) + "'";

            Statement st = conn.createStatement();
            st.execute(query);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public static void deleteCustomer(String id) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            PreparedStatement st = conn.prepareStatement("DELETE FROM customer WHERE customer_id = ?");
            st.setString(1, id);
            st.execute();

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
    
    public static void updateTotalSum(int id, double total) {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/web_shop", "root", "");) {

            String query = "UPDATE customer SET total='" + String.valueOf(total) + "' WHERE customer_id = '" + String.valueOf(id) + "'";

            Statement st = conn.createStatement();
            st.execute(query);

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
