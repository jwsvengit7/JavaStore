package Implement;

import Abstraction.CustomerInteface;
import DataAccess.Filreader;
import Model.Customer;
import Model.Product;

import java.io.IOException;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CustomerImplementation extends Thread implements CustomerInteface {

    public void run(){
        try {

        }catch (Exception e){
            System.out.println(e+ " present error");
        }
    }
    @Override
    public void BuyProductFromStore(PriorityQueue<Customer> CustomerList) throws IOException {

        /******** EXCEL OBJECT *******/

        Filreader filreader = new Filreader();
        String file = "src/main/resources/execel.xlsx";
        filreader.setFilreader(file);
        String showUp = "";

        List<Product> checks = filreader.fileReader(filreader.getFilreader());
        System.out.println("List of Product ");

        /******** LOOP THROUGH PRODUCT ON EXCEL *******/

        for (int i = 0; i < checks.size(); i++) {
            System.out.println(i + 1 + " " + checks.get(i).getName() + " Price: $" + checks.get(i).getPrice() + " Quantity: " + checks.get(i).getQuantity());
        }
        /******** VALIDATE RESULT *******/
        while(CustomerList.size()!=0) {
            String nameFirst = CustomerList.peek().getName();
            CustomerList.poll();
            System.out.println(nameFirst+" is the Next customer");

            Scanner scanner = new Scanner(System.in);
            System.out.println("CHOOSE A PRODUCT TO BUY");

            int count = scanner.nextInt();
            if (count <= checks.size()) {
                int toComfirmIndex = count - 1;
                String name = checks.get(toComfirmIndex).getName();
                int price = checks.get(toComfirmIndex).getPrice();
                int qty = checks.get(toComfirmIndex).getQuantity();
                System.out.println("ENTER QUANTITY");
                int qtyOf = scanner.nextInt();

                if (qtyOf > qty) {
                    showUp = "We don't have more than that";
                } else {
                    System.out.println("ENTER PRICE");
                    int priceof = scanner.nextInt();
                    if (priceof <= price) {
                        showUp = "Congratulations you have successfully bought the product";

                    } else {
                        showUp = "Insufficient funds";
                    }
                }


            }
            System.out.println("The Remaining Customers are :" + CustomerList);
            System.out.println(showUp);
        }
    }

}
