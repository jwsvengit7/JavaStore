package Abstraction;

import Model.Cashier;
import Model.Manager;
import Model.Product;

import java.io.IOException;
import java.util.List;

public interface CashierInterface {
    public String  cashierSale(List<Cashier> CashierList, Manager manager) throws IOException;

}
