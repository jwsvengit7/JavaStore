package Abstraction;
import Model.Customer;

import java.io.IOException;
import java.util.PriorityQueue;

public interface CustomerInteface {
    void BuyProductFromStore(PriorityQueue<Customer> CustomerList) throws IOException;
}
