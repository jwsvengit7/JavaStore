package Model;

import Abstraction.CustomerInteface;
import DataAccess.Filreader;

import java.io.IOException;

import java.util.*;

public class Customer implements CustomerInteface {
        private String name;
        private String email;
        private int id;
    public Customer(String name,String email,int id){
        this.name=name;
        this.email=email;
        this.id=id;

    }

    public Customer(){}
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getEmail() {
            return email;
        }
        public void setId(int id) {
            this.id = id;
        }
        public int getId() {
            return id;
        }
        public void setEmail(String email) {
            this.email = email;
        }
        @Override
        public String BuyProductFromStore(PriorityQueue<String> CustomerList) throws IOException {
            String namefirst = CustomerList.peek();
            System.out.println(namefirst);

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

            Scanner scanner = new Scanner(System.in);
            System.out.println("CHOOSE A PRODUCT TO BUY");

            int count = scanner.nextInt();
            if (count < checks.size()) {
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
            return showUp;
        }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                '}';
    }

}
