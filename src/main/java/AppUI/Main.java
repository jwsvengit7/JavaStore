package AppUI;

import DataAccess.Filreader;
import Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        Manager manager = new Manager("joy","samuel","joy@gmail.com",12);
        List<Product> products = new ArrayList<>();
        Product product = new Product("Rice",32,2);
        Customer customer = new Customer();

        Filreader filreader = new Filreader();
        String file ="src/main/resources/execel.xlsx";
        filreader.setFilreader(file);
        System.out.println(filreader.fileReader(file));

        List<Staff> listOfStaff = new ArrayList<>();
        List<Cashier> listOfcasjiers = new ArrayList<>();
        Cashier cashier = new Cashier();
        listOfStaff.add(manager);

//        System.out.println("manager: "+listOfStaff);
        System.out.println(manager.managerHire(listOfcasjiers));
        System.out.println(manager.managerFire(listOfcasjiers));
        System.out.println(cashier.cashierSale(listOfcasjiers,manager));
        System.out.println(customer.BuyProductFromStore(product));


    }
}
