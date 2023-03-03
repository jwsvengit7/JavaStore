package Model;

import Abstraction.CashierInterface;
import DataAccess.Filreader;
import Model.Product;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Cashier extends Staff implements CashierInterface {
    public Cashier(String firstName, String lastName, String email, int StaffID) {
        super(firstName, lastName, email, StaffID);
    }
    public Cashier() {}
    @Override
    public String cashierSale(List<Cashier> CashierList,Manager manager) throws IOException {
        manager.managerHire(CashierList);
        Filreader filreader = new Filreader("src/main/resources/execel.xlsx");
        String file = filreader.getFilreader();
        filreader.setFilreader(file);
        List<Product> checks =  filreader.fileReader(filreader.getFilreader());
        String showUp ="";
        System.out.println("List of Product To sale ");
        for (int i =0;i<checks.size();i++){
            System.out.println(i+1+" "+ checks.get(i).getName()+" Price: $"+checks.get(i).getPrice()+" Quantity: "+checks.get(i).getQuantity());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("CHOOSE A PRODUCT TO SELL");

        int count=scanner.nextInt();
        if(count<checks.size()) {
            int toComfirmIndex = count-1;
            String name = checks.get(toComfirmIndex).getName();
            int price = checks.get(toComfirmIndex).getPrice();
            int qty = checks.get(toComfirmIndex).getQuantity();
                System.out.println("ENTER QUANTITY");
                int qtyOf = scanner.nextInt();

            if(qtyOf>qty){
                showUp="We don't have more than that";
            }else {
                System.out.println("ENTER PRICE");
                int priceof = scanner.nextInt();
                if (priceof <= price) {
                    showUp="Congratulations you have successfully sell a product";
                    System.out.println(printReciept(checks ,toComfirmIndex));
                }
            }

        }

        return showUp;
    }

    public String  printReciept(List<Product> products,int index) {
        String found="";
      found ="PRODUCT RECEIPT \n" +
              "*****************\n" +
            "Name: "+products.get(index).getName()+"\n" +
              "*******************\n"+
              "Price: $"+products.get(index).getPrice()+"\n" +
              "*******************\n"+
              "Quantity: $"+products.get(index).getQuantity()+"\n" +
              "*******************\n"+
            "Checkout Reciept";;
            return found;
    }
}
