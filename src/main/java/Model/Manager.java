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
    public List<Cashier> managerHire(List<Cashier> listOfcasjiers) {
        String name = "";
        String lastname = "";
        String email = "";
        int id=0;
        if (listOfcasjiers.size()<1) {
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


                Cashier cashier1 = new Cashier(name,lastname,email,id);
                listOfcasjiers.add(cashier1);
            }
        }
        return listOfcasjiers;
    }
    public List<Cashier> managerFire(List<Cashier> listOfcasjiers) {

        for (int c=0;c<listOfcasjiers.size();c++){
            System.out.println("Cashiers Firstname "+listOfcasjiers.get(c).getFirstName()+" Lastname: "+listOfcasjiers.get(c).getFirstName());

        }
        try {

            System.out.println("Do you want to fire a cashier");
            System.out.println("Press 1 to Fire Press 2 to continue");
            Scanner scanner = new Scanner(System.in);
            int confirm = scanner.nextInt();

            if (confirm == 1) {
              checkIf(listOfcasjiers);

            } else {
                System.out.println("Continue");
            }
            for (int c = 0; c < listOfcasjiers.size(); c++) {
                System.out.println("Cashiers Firstname " + listOfcasjiers.get(c).getFirstName() + " Lastname: " + listOfcasjiers.get(c).getFirstName());
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return listOfcasjiers;


    }
    void checkIf(List<Cashier> listOfcasjiers) {
        boolean status = true;
        int check = 0;
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < listOfcasjiers.size(); i++) {

            String press = scanner.nextLine();
            if (press.equals(listOfcasjiers.get(i).getFirstName())) {
                status = true;
                check = i;
            } else {
                status = false;
                check = -1;
            }
            if (status == true && check > -1) {
                listOfcasjiers.remove(check);

                System.out.println(listOfcasjiers);
            }
        }
    }

}
