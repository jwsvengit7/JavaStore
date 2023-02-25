package Abstraction;

import Model.Cashier;
import Model.Manager;

import java.io.IOException;
import java.util.List;

public interface CashierInterface {
    public List<Cashier>  cashierSale(List<Cashier> cashiers, Manager manager) throws IOException;
    public List<Cashier> printReciept(List<Cashier> cashiers);
}
