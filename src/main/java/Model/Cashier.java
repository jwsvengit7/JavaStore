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

    public Cashier() {
    }

    @Override
    public String cashierSale(List<Cashier> cashiers,Manager manager) throws IOException {
        manager.managerHire(cashiers);
        Filreader filreader = new Filreader();
        String file ="src/main/resources/execel.xlsx";
        filreader.setFilreader(file);
        List<Product> checks =  filreader.fileReader(filreader.getFilreader());
        System.out.println("List of Product ");
        for (int i =0;i<checks.size();i++){
            System.out.println(i+1+" "+ checks.get(i).getName());
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
                System.out.println("We don't have more than that");
            }else{
                System.out.println("ENTER PRICE");
                int priceof = scanner.nextInt();
                if(priceof<=price){
                    System.out.println("Congratilations you have successfully bought the product");

                }else{
                    System.out.println("Insufficient funds");
                }

            }
        }
        return "";




    }

    @Override
    public List<Cashier>  printReciept(List<Cashier> cashiers) {
    return cashiers;
    }
}
