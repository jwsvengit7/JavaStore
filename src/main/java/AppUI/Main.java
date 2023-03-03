package AppUI;

import DataAccess.Filreader;
import Model.*;

import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        /******* LIST AND QUEUE *******/
        List<Staff> StaffList = new ArrayList<>();
        List<Cashier> CashierList = new ArrayList<>();
        PriorityQueue<Customer> CustomerList=new PriorityQueue<>(new RequestComparator());


        /******** MANAGER OBJECT *******/
        Manager manager = new Manager("joy","samuel","joy@gmail.com",12);
        /******* PRODUCT OBJECT *******/
        Product product = new Product("Meat",4000,10);
        Product product2 = new Product("Rice",4000,15);
        Product product3 = new Product("Meat",4000,1);
        Product product4 = new Product("Meat",4000,11);

        /******* CASHIER OBJECT ********/
        Cashier cashier = new Cashier();

        /******* CUSTOMER OBJECT ********/
        Customer customer = new Customer();
        Customer one = new Customer("Jack","chiorlujack@gmail.com",1,product);
        Customer two = new Customer("William","williamj045@gmail.com",2,product2);
        Customer three = new Customer("Samuel","samuelin@gmail.com",3,product3);
        Customer four = new Customer("david","david@gmail.com",4,product4);


        /******* ADDING CUSTOMER TO THE QUEUE *******/
        PriorityQueue<Integer>b=new PriorityQueue<>();
        b.add(10);
        b.add(15);
        b.add(1);
        b.add(11);
        System.out.println(b);

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


        /******* READING YOUR PRODUCT FROM EXCEL *******/
        StaffList.add(manager);
        /****************************/

        Filreader filreader = new Filreader("src/main/resources/execel.xlsx");
        String file = filreader.getFilreader();
        filreader.setFilreader(file);
        filreader.fileReader(file);
        filreader.showProduct();



       /*********PRORITYQUEUE*********/



//        System.out.println(manager.managerHire(CashierList));
//        System.out.println(manager.managerFire(CashierList));
//        System.out.println(cashier.cashierSale(CashierList,manager));
//        customer.BuyProductFromStore(CustomerList);




    }
}
