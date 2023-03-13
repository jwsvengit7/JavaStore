package Abstraction;
import model.Customer;

import java.io.IOException;
import java.util.Queue;

public interface CustomerInteface {
    void BuyProductFromStore(Queue<Customer> CustomerList) throws IOException;
}
