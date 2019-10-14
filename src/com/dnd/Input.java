package com.dnd;

import java.io.IOException;
import java.io.InputStreamReader;
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

    public void promptIntInput(String promptText) {
        Scanner scanner = new Scanner(new InputStreamReader(System.in));
        System.out.print(promptText + ": ");
        int number = scanner.nextInt();
        System.out.println("Integer Input: " + number);
    }
}
