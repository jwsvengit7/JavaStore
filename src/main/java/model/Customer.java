package model;

import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
@Getter
@Setter
public class Customer implements Comparable<Customer> {
    private String name;
    private String email;
    private int id;
    private Queue<Customer> Fifo= new LinkedList<>();
    private Queue<Customer> Priority= new PriorityQueue<>();
    private LinkedList<Product> cart;
    public Customer(String name, String email, int id, LinkedList<Product> cart) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.cart = new LinkedList<>();
    }
    public Customer() {}

    public void addCart(Product product) {
        cart.offer(product);
    }
    public void addToFIFO(Customer customer){
        Fifo.offer(customer);
        System.out.println(customer.getName()+" joined FIFO queue");
    }
    public void addToPrority(Customer customer){
        Customer adds =getFifo().poll();
        getPriority().offer(adds);
        System.out.println(customer.getName()+" just join base on items");
    }
    @Override
    public int compareTo(Customer o) {
        return o.getCart().size()-this.getCart().size();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", cart=" + cart +
                '}';
    }
}
