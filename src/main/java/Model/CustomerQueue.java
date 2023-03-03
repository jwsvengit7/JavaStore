package Model;

import DataAccess.Filreader;

public class CustomerQueue {
    private Customer customer;
    private Filreader filreader;

    public CustomerQueue(Customer customer, Filreader filreader) {
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Filreader getFilreader() {
        return filreader;
    }

    public void setFilreader(Filreader filreader) {
        this.filreader = filreader;
    }

    @Override
    public String toString() {
        return "CustomerQueue{" +
                "customer=" + customer +
                ", filreader=" + filreader +
                '}';
    }
}
