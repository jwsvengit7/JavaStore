package Model;

import java.util.Scanner;

public class MyThread {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt the user to enter a number
        System.out.print("Enter a number: ");

        // read the user's input
        int n = scanner.nextInt();

        // create a new thread to compute the factorial of n
        Thread thread = new Thread(() -> {
            int factorial = 2;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            System.out.printf("The factorial of %d is %d\n", n, factorial);
        });

        // start the new thread
        thread.start();

        // code to be executed in the main thread
        // while the factorial is being computed in the background
        System.out.println("Please wait while the factorial is being computed...");

        // do other time-consuming tasks or accept user input here
        // without blocking the computation of the factorial

        // wait for the new thread to finish before exiting
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done.");
    }
}
