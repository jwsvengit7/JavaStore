package AppUI;

import dataAccess.Filreader;
import implement.CashierImplement;
import implement.CustomerImplementation;
import implement.ManagerImplement;
import model.*;

import java.io.IOException;
import java.util.*;
import static java.lang.System.out;
import static model.Product.DataRecordStore;

public class Main {
    public static void main(String[] args) throws IOException {

        /* ****** LIST AND QUEUE *******/
        ArrayList<Staff> StaffList = new ArrayList<>();
        ArrayList<Cashier> CashierList = new ArrayList<>();

        /* ******* MANAGER OBJECT *******/
        Manager manager = new Manager("joy","samuel","joy@gmail.com",12);
        StaffList.add(manager);
        ManagerImplement managerImplement = new ManagerImplement();
        CustomerImplementation customerIn = new CustomerImplementation();

        /* ***** READING YOUR PRODUCT FROM EXCEL *******/

        Filreader filreader = new Filreader();
        filreader.fileReader(filreader.getFile());

        /* ****** CASHIER OBJECT ********/
        CashierImplement cashier = new CashierImplement();

        /* ****** ADDING CUSTOMER CART ********/
        LinkedList<Product> productListFor1 = new LinkedList<>();

        /* ******* CUSTOMER OBJECT ********/
        Customer one = new Customer("Jack","chiorlujack@gmail.com",1,productListFor1);
        Customer two = new Customer("William","williamj045@gmail.com",2,productListFor1);
        Customer three = new Customer("Samuel","samuelin@gmail.com",3,productListFor1);
        Customer four = new Customer("david","david@gmail.com",4,productListFor1);


        four.addCart(new Product("RICE",12,2));
        four.addCart(new Product("EGG",12,2));
        four.addCart(new Product("PIZZA",12,2));
        two.addCart(new Product("RICE",12,2));
        three.addCart(new Product("TOMATO",2,2));
        three.addCart(new Product("MEAT",2,2));
        one.addCart(new Product("CHOCOLATE",12,2));

        out.println(DataRecordStore);


        /* ****** ADDING CUSTOMER TO THE QUEUE *******/

        Customer customers = new Customer();
        Customer[] arr = {one,two,three,four};
        for (Customer customer : arr) {
            customers.addToFIFO(customer);
        }
        for (Customer customer : arr) {
            customers.addToPrority(customer);
        }

        out.println(customers.getPriority());

//        CustomerThread thread = new CustomerThread(customers.getPriority(),Product,customerIn);
//        Thread thread1 = new Thread(thread);
//        thread1.start();
        filreader.showProduct();
        customerIn.BuyProductFromStore(customers.getPriority());

        out.println(managerImplement.managerHire(CashierList));
        out.println(managerImplement.managerFire(CashierList));
        out.println(cashier.cashierSale(CashierList,managerImplement));


    }
}
