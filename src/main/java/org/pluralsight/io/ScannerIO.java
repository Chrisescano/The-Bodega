package org.pluralsight.io;

import java.util.Scanner;

public class ScannerIO {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (IllegalArgumentException e) {
                System.out.println("Oops, Expecting An Integer Input. Try Again");
            }
        }
    }
}
