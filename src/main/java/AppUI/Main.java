package AppUI;

import DataAccess.Filreader;
import Implement.CashierImplement;
import Implement.CustomerImplementation;
import Implement.ManagerImplement;
import Model.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {

        /******* LIST AND QUEUE *******/
        List<Staff> StaffList = new ArrayList<>();
        List<Cashier> CashierList = new ArrayList<>();
        PriorityQueue<Customer> CustomerList=new PriorityQueue<>(new RequestComparator());
        


        /******** MANAGER OBJECT *******/
        Manager manager = new Manager("joy","samuel","joy@gmail.com",12);
        ManagerImplement managerImplement = new ManagerImplement();
        CustomerImplementation customerIn = new CustomerImplementation();

        /******* PRODUCT OBJECT *******/
        Product product = new Product("Meat",4000,10);
        Product product2 = new Product("Rice",4000,15);
        Product product3 = new Product("Meat",4000,1);
        Product product4 = new Product("Meat",4000,11);

        /******* CASHIER OBJECT ********/
        CashierImplement cashier = new CashierImplement();

        /******* CUSTOMER OBJECT ********/
        Customer one = new Customer("Jack","chiorlujack@gmail.com",1,product);
        Customer two = new Customer("William","williamj045@gmail.com",2,product2);
        Customer three = new Customer("Samuel","samuelin@gmail.com",3,product3);
        Customer four = new Customer("david","david@gmail.com",4,product4);


        /******* ADDING CUSTOMER TO THE QUEUE *******/
    

        List<Customer> nami = new ArrayList<>();
        nami.add(one);
        nami.add(two);
        nami.add(three);
        nami.add(four);
        int x = 23;

        for (Customer s : nami) {

            if (s.getProductLists().getQuantity()<x){
                CustomerList.add(s);
            }

        }


        System.out.println(CustomerList);
        StaffList.add(manager);

        /****** READING YOUR PRODUCT FROM EXCEL *******/

        /****************************/

        Filreader filreader = new Filreader("src/main/resources/execel.xlsx");
        String file = filreader.getFilreader();
        filreader.setFilreader(file);
        filreader.fileReader(file);
        filreader.showProduct();


        System.out.println(managerImplement.managerHire(CashierList));
        System.out.println(managerImplement.managerFire(CashierList));
        System.out.println(cashier.cashierSale(CashierList,managerImplement));
        customerIn.BuyProductFromStore(CustomerList);




    }
}
