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

        Scanner scanner = new Scanner(System.in);
        System.out.println("ENTER A PRODUCT TO BUY");

        String name=scanner.nextLine();
        System.out.println("ENTER A PRODUCT PRICE");

        int price= Integer.parseInt(scanner.next());
        System.out.println("ENTER A PRODUCT QTY");

        int qty = Integer.parseInt(scanner.next());
        String confirm ="";
        int length = filreader.fileReader(filreader.getFilreader()).size();
        List<Product> check =  filreader.fileReader(filreader.getFilreader());
        for(int i = 0;i<length;i++){
           if (price!=check.get(i).getPrice()) {
                confirm ="Price too low to buy that product";
            }
            else if (qty > check.get(i).getQuantity()) {
                confirm ="We don't have more of that product";
            } else{
                confirm="Successful Purchase a product";
            }
        }
       return confirm;
    }

    @Override
    public List<Cashier>  printReciept(List<Cashier> cashiers) {
    return cashiers;
    }
}
