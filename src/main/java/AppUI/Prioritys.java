package AppUI;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Request{


    private Prioritys customer;
    private Store store;

    public Request(Prioritys customer, Store store) {
        this.customer = customer;
        this.store = store;
    }

    public Prioritys getUsers() {
        return customer;
    }

    public void setUsers(Prioritys customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }
    @Override
    public String toString() {
        return "Request{" +
                "users=" + customer +
                ", store=" + store +
                '}';
    }
}
class Store{
    private String storeid;
    private String name;

    public Store(String storeid, String name) {
        this.storeid = storeid;
        this.name = name;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeid='" + storeid + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Prioritys {
    private String name;
    private String email;
    private  int id;
    private  int itemQuantity;
    private List<Prioritys> listTo = new ArrayList<>();

    public Prioritys(String name, String email, int id, int itemQuantity) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.itemQuantity = itemQuantity;
    }
    public Prioritys(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public int getId(int id) {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getItemQuantity() {
        return itemQuantity;
    }
    public Prioritys removeList(int id) {
        return listTo.remove(id);
    }


    private List<Prioritys> setList(Prioritys customer) {
        this.listTo.add(customer);
    return listTo;
    }
    public void setItemQuantity(int itemQuantity) {
        this.itemQuantity = itemQuantity;
    }

    @Override
    public String toString() {
        return "Prioritys{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id=" + id +
                ", itemQuantity=" + itemQuantity +
                '}';
    }
      static class RequestComparator implements Comparator<Request> {
        @Override


         public int compare(Request o1, Request o2) {
//           o2 if (o1.getUsers().getName().equals(User_Status.FIVE)&& (o2.getUsers().getItemQuantity()==User_Status.FOUR) || o2.getUsers().getUser_status().equals(User_Status.THREE))){
//                return 1;
//            }
//            if (o1.getUsers().getUser_status().equals(User_Status.FOUR) || (o1.getUsers().getUser_status().equals(User_Status.THREE) &&o2.getUsers().getUser_status().equals(User_Status.FIVE)) ){
//                return -1;
//            }
//
           return -1;
        }

    }

    public static void main(String[] args) {


        Point x= new Point(2,4);
        System.out.println(x);

        var customer = new Prioritys("jack","jwsven@gmail.com",12,4);
        var customer2 = new Prioritys("gideon","gideon@gmail.com",2,5);
        var customer6 = new Prioritys("hfh","gidfgfeon@gmail.com",23,6);
        var customer3 = new Prioritys("david","david@gmail.com",1,1);
        var customer4 = new Prioritys("daniel","daniel@gmail.com",11,2);



        Request one = new Request(customer,new Store("rice/12", "rice"));
        Request two = new Request(customer2,new Store("garri/23","brewd"));
        Request three = new Request(customer3,new Store("beans/12", "BEANS"));
        Request four = new Request(customer4,new Store("yy", "TOMATO"));
        Request five =new Request(customer6,new Store("in/u","INDOMIE"));



        PriorityQueue<Request> listOfRequest=new PriorityQueue<>(new RequestComparator());
        listOfRequest.add(one);
        listOfRequest.add(two);
        listOfRequest.add(three);
        listOfRequest.add(four);
        listOfRequest.add(five);
        System.out.println(listOfRequest);

//        Object[] obj= {customer,customer2,customer3,customer6};
//
//        for (int xx=0;xx<obj.length;xx++){
//
//            customer.setList((Prioritys) obj[xx]);
//        }
//
//        List<Prioritys> objAll = customer.setList(customer4);
//        System.out.println(objAll);
//        int [] ArrayLists=new int[1];
//        ArrayLists[0]=0;
//
//        AtomicInteger index= new AtomicInteger(0);
//
//        objAll.forEach((n)->{
//            int check = n.getItemQuantity();
//            String name =n.getName();
//            String email =n.getEmail();
//            int id =n.getId();
//
//            int c =index.getAndIncrement();
//            while (ArrayLists[0]<check){
//                if(ArrayLists[0]<check) {
//                    ArrayLists[0] = check;
//                    priority.add(ArrayLists[0]);
//                    priority.add(name);
//                    priority.add(email);
//                    priority.add(id);
//                    priority.add(c);
//                }
//
//            }
//
//        });
//      System.out.println(priority);
//
//        Object[][]cars= {{2},{4}, {4}, {67}, {98}};
//        System.out.println(Arrays.deepToString(cars));
//        boolean loopTrue = Arrays.stream(cars).anyMatch((objects) -> objects[0].equals(67));
//        System.out.println(loopTrue);


    }



}
