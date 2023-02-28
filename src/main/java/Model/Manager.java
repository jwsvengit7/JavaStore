package Model;

import Abstraction.MangerInterface;

import java.util.List;
import java.util.Scanner;

public class Manager extends Staff implements MangerInterface {
    public Manager(String firstName, String lastName, String email, int StaffID) {
        super(firstName, lastName, email, StaffID);
    }
    public Manager() {}
    @Override
    public List<Cashier> managerHire(List<Cashier> CashierList) {
        String name = "";
        String lastname = "";
        String email = "";
        int id=0;
        /******** VALIDATE RESULT *******/
        if (CashierList.size()<1) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a name");
            name = scanner.nextLine();
            System.out.println("Enter a lastname");
            lastname = scanner.nextLine();
            System.out.println("Enter a email");
            email = scanner.nextLine();
            System.out.println("Enter a id");
            id = scanner.nextInt();
            if (name.isEmpty()){
                System.out.println("name cannot be empty");
            } else if (email.isEmpty()) {
                System.out.println("email cannot be empty");
            }
            else{
                /******** OBJECT OF CASHIER *******/

                Cashier cashier1 = new Cashier(name,lastname,email,id);
                CashierList.add(cashier1);
            }
        }
        return CashierList;
    }
    public List<Cashier> managerFire(List<Cashier> CashierList) {

        for (int c=0;c<CashierList.size();c++){
            System.out.println("Cashiers Firstname "+CashierList.get(c).getFirstName()+" Lastname: "+CashierList.get(c).getFirstName());
        }
        try {
            System.out.println("Do you want to fire a cashier");
            System.out.println("Press 1 to Fire Press 2 to continue");
            Scanner scanner = new Scanner(System.in);
            int confirm = scanner.nextInt();
            if (confirm == 1) {
              checkIf(CashierList);

            } else {
                System.out.println("Continue");
            }
            for (int c = 0; c < CashierList.size(); c++) {

                System.out.println("Cashiers Firstname " + CashierList.get(c).getFirstName() + " Lastname: " + CashierList.get(c).getFirstName());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return CashierList;

    }
    void checkIf(List<Cashier> CashierList) {
        boolean status = true;
        int check = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < CashierList.size(); i++) {

            String press = scanner.nextLine();
            if (press.equals(CashierList.get(i).getFirstName())) {
                status = true;
                check = i;
            } else {
                status = false;
                check = -1;
            }
            if (status == true && check > -1) {
                CashierList.remove(check);

                System.out.println(CashierList);
                return;
            }
        }
    }

}
