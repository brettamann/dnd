package com.masters_of_destiny.Utilities;

public class Screen {
    //public static final String RESET = "\u001B[0m";
    //public static final String BLACK = "\u001B[30m";
    //public static final String RED = "\u001B[31m";
    //public static final String GREEN = "\u001B[32m";
    //public static final String YELLOW = "\u001B[33m";
    //public static final String BLUE = "\u001B[34m";
    //public static final String PURPLE = "\u001B[35m";
    //public static final String CYAN = "\u001B[36m";
    //public static final String WHITE = "\u001B[37m";
//
    //public static final String BLACK_BACKGROUND = "\u001B[40m";
    //public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    //public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    //public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    //public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    //public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    //public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    //public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void newlines(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    public static void printByColor(String color, String text) {
        System.out.print(color + text + Colors.RESET);
    }

    public static void printLnByColor(String color, String text) {
        System.out.println(color + text + Colors.RESET);
    }

    public static void horizontalRule() {
        System.out.println("----------------------------------------------");
    }

    public static void println(String textToPrint) {
        System.out.println(textToPrint);
    }

    public static void print(String textToPrint){
        System.out.print(textToPrint);
    }

    public void blackText(String textToPrint) {
        System.out.println(Colors.BLACK + textToPrint + Colors.RESET);
        System.out.println();
    }

    public static void redText(String textToPrint) {
        System.out.println(Colors.RED + textToPrint + Colors.RESET);
    }

    public static void purpleText(String textToPrint) {
        System.out.println(Colors.PURPLE + textToPrint + Colors.RESET);
    }

    public static void greenText(String textToPrint) {
        System.out.println(Colors.GREEN + textToPrint + Colors.RESET);
    }

    public static void yellowText(String textToPrint) {
        System.out.println(Colors.YELLOW + textToPrint + Colors.RESET);
    }

    public static void cyanText(String textToPrint) {
        System.out.println(Colors.CYAN + textToPrint + Colors.RESET);
    }

    public static void whiteText(String textToPrint) {
        System.out.println(Colors.WHITE + textToPrint + Colors.RESET);
    }

    public static void blueText(String textToPrint) {
        System.out.println(Colors.BLUE + textToPrint + Colors.RESET);
    }

    public static void resetAllColor() {
        System.out.println(Colors.RESET);
        System.out.print(Colors.BLACK_BACKGROUND);
    }
}
