package Model;

import Abstraction.CashierInterface;
import DataAccess.Filreader;

import java.io.IOException;
import java.util.List;

public class Cashier extends Staff implements CashierInterface {
    public Cashier(String firstName, String lastName, String email, int StaffID) {
        super(firstName, lastName, email, StaffID);
    }

    public Cashier() {
    }

    @Override
    public List<Cashier> cashierSale(List<Cashier> cashiers,Manager manager) throws IOException {
       manager.managerHire(cashiers);
        Filreader filreader = new Filreader();
        String file ="src/main/resources/execel.xlsx";
        filreader.setFilreader(file);
        System.out.println(filreader.fileReader(filreader.getFilreader()));


       return cashiers;


    }

    @Override
    public List<Cashier>  printReciept(List<Cashier> cashiers) {
return cashiers;
    }
}
