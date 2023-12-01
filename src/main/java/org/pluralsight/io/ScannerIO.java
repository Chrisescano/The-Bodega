package org.pluralsight.io;

import java.util.InputMismatchException;
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
                int userInput = scanner.nextInt();
                scanner.nextLine(); //clear buffer
                return userInput;
            } catch (InputMismatchException e) {
                System.out.println("Oops, Expecting An Integer Input. Try Again");
                scanner.nextLine();
            }
        }
    }

    public static boolean getBooleanInput(String prompt) {
        while (true) {
            String userInput = getStringInput(prompt).toUpperCase();
            switch (userInput) {
                case "YES", "Y", "TRUE", "T", "CONFIRM" -> { return true; }
                case "NO", "N", "FALSE", "F", "CANCEL" -> { return false; }
                default -> System.out.println("Oops, Expecting Yes Or No. Try Again");
            }
        }
    }
}
