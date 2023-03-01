package Abstraction;
import java.io.IOException;
import java.util.PriorityQueue;

public interface CustomerInteface {
    void BuyProductFromStore(PriorityQueue<String> CustomerList) throws IOException;
}
