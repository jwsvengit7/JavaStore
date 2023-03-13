package Abstraction;

import model.Cashier;

import java.util.List;

public interface MangerInterface {
    public List<Cashier> managerFire(List<Cashier> CashierList);
    public List<Cashier> managerHire(List<Cashier> CashierList);
}
