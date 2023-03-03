package Model;

public class CustomerBody {
    private String name;
    private String email;
    private int id;
    private Product productLists;

    public CustomerBody(String name, String email, int id, Product productLists) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.productLists = productLists;
    }

    public CustomerBody(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Product getProductLists() {
        return productLists;
    }

    public void setProductLists(Product productLists) {
        this.productLists = productLists;
    }

    @Override
    public String toString() {
        return "CustomerBody{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", productLists=" + productLists +
                '}';
    }
}
