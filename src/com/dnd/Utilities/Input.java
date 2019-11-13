package com.dnd.Utilities;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Input {
    public void readInputText() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Reading Input from console using Scanner in Java ");
        System.out.println("Please enter your Input: ");
        String input = scanner.nextLine();
        System.out.println("User Input from console: " + input);
    }

    public void readInputInt() {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.println("Reading int input from console using Scanner in Java ");
        int number = scanner.nextInt();
        System.out.println("Integer Input: " + number);
    }

    public void promptTextInput(String promptText) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print(promptText + ": ");
        String input = scanner.nextLine();
        System.out.println("User Input from console: " + input);
    }

    public static String promptTextInputQuiet(List<String> validCommands) {
        boolean badInput = true;
        String input = "";

        while (badInput) {
            try {
                Scanner scanner = new Scanner(new InputStreamReader(System.in));
                input = scanner.nextLine();

                badInput = !validCommands.contains(input.toLowerCase());

            } catch (Exception ex) {
                System.out.println("Invalid Input! Retry!");
                badInput = true;
            }

        }

        return input;
    }

    public static String promptTextInput(String promptText, List<String> validCommands) {
        boolean badInput = true;
        String input = "";

        while(badInput) {
            try {
                Scanner scanner = new Scanner(new InputStreamReader(System.in));
                System.out.print(promptText + ": ");
                input = scanner.nextLine();

                badInput = !validCommands.contains(input.toLowerCase());

            } catch (Exception ex){
                System.out.println("Invalid Input! Retry!");
                badInput = true;
            }

        }

        return input;
    }
    public static int promptIntInputWithinRange(String promptText, int min, int max) {
        boolean badInput = true;
        int input = 0;

        while(badInput) {
            try {
                Scanner scanner = new Scanner(new InputStreamReader(System.in));
                System.out.print(promptText + ": ");
                input = scanner.nextInt();

                badInput = input < min || input > max;
            } catch (Exception ex) {
                System.out.println("Invalid Input! Retry!");
                badInput = true;
            }
        }

            return input;
    }
}
