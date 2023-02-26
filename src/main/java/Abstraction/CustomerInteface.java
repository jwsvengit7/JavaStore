package Abstraction;

import Model.Customer;
import Model.Product;

import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Queue;

public interface CustomerInteface {
    public void BuyProductFromStore(PriorityQueue<String> CustomerList) throws IOException;
}
