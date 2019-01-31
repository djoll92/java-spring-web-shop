package model;

public class Customer {
    
    private int id;
    private String name;
    private String email;
    private double total = 0;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer(int id, String name, String email, double total) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.total = total;
    }

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Customer() {
    }

    @Override
    public String toString() {
        return "ID: " + id + " | " + name;
    }
    
    
}
