package Model;

public class ThreadAll extends Thread{
    public void run() {
        for (int i=1;i<=20;i++) {
            System.out.println(i);
            try {
                Thread.sleep(i);
            } catch (Exception e) {
                System.out.println("error " + e);
            }
        }
    }
}
