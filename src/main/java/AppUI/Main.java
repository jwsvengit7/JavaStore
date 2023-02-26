package AppUI;

import DataAccess.Filreader;
import Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {

        /******* LIST AND QUEUE *******/
        List<Product> products = new ArrayList<>();

        PriorityQueue<String> CustomerList = new PriorityQueue<>();
        List<Staff> StaffList = new ArrayList<>();
        List<Cashier> CashierList = new ArrayList<>();



        /******** MANAGER OBJECT *******/
        Manager manager = new Manager("joy","samuel","joy@gmail.com",12);
        /******* PRODUCT OBJECT *******/
        Product product = new Product("Meat",4000,100);

        /******* CASHIER OBJECT ********/
        Cashier cashier = new Cashier();

        /******* CUSTOMER OBJECT ********/
        Customer customer = new Customer();
        Customer one = new Customer("Jack","chiorlujack@gmail.com",1);
        Customer two = new Customer("William","williamj045@gmail.com",2);
        Customer three = new Customer("Samuel","samuelin@gmail.com",3);
        Customer four = new Customer("david","david@gmail.com",4);

        /******* ADDING CUSTOMER TO THE QUEUE *******/

        CustomerList.add(one.getName());
        CustomerList.add(two.getName());
        CustomerList.add(three.getName());
        CustomerList.add(four.getName());

        /******* READING YOUR PRODUCT FROM EXCEL *******/
        StaffList.add(manager);
        /****************************/

        Filreader filreader = new Filreader("src/main/resources/execel.xlsx");
        String file = filreader.getFilreader();
        filreader.setFilreader(file);
        System.out.println(filreader.fileReader(file));
        System.out.println(manager.managerHire(CashierList));
        System.out.println(manager.managerFire(CashierList));
        System.out.println(cashier.cashierSale(CashierList,manager));
        System.out.println(customer.BuyProductFromStore(CustomerList));



    }
}
