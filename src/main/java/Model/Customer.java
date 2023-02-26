package Model;

import Abstraction.CustomerInteface;
import DataAccess.Filreader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Customer implements CustomerInteface {
        private String name;
        private int qty;
        private int price;

        public Customer(){}
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Customer{" +
                    "name='" + name + '\'' +
                    ", qty=" + qty +
                    ", price=" + price +
                    '}';
        }

        @Override
        public String BuyProductFromStore(Product item) {
            String name = item.getName();
            Filreader filreader = new Filreader();
            String file ="src/main/resources/execel.xlsx";
            filreader.setFilreader(file);
            List<String> buyIfExist = new ArrayList<>();
            String found = "Product out of stock";
            int count = 0;
            try {
                List<Product> checks =  filreader.fileReader(filreader.getFilreader());
                for (int i = 0; i < checks.size(); i++) {
                    String productOnStore = checks.get(i).getName();
                    buyIfExist.add(productOnStore);
                }
                for (int i = 0; i < buyIfExist.size(); i++) {
                    int price = checks.get(i).getPrice();
                    int qty = checks.get(i).getQuantity();
                    int total = price * qty;
                    String priceProduct = "" + price + "";

                    if (buyIfExist.get(i).equals(name)) {
                        count++;
                        found = "You have Bought\n" +
                                "Name: " + buyIfExist.get(i) + "\n" +
                                "Price: $" + priceProduct + "\n" +
                                "Total Price: $" + total;
                    }
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return found;
        }
}
