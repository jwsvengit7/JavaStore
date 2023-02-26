package Model;

public class Threads extends Thread {
    private static int amount = 0;
    public void run(){
        amount++;
    }
    public void runAll(){
        amount+=5;
    }
    public static void main(String[] args) {
        Threads thread = new Threads();
        thread.start();
        System.out.println(amount);



    }


}