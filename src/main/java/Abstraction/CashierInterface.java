package Abstraction;

import implement.ManagerImplement;
import model.Cashier;

import java.io.IOException;
import java.util.List;

public interface CashierInterface {
    public String  cashierSale(List<Cashier> CashierList, ManagerImplement manager) throws IOException;

}
