package com.dnd.Utilities;

public class Screen {
    //public static final String ANSI_RESET = "\u001B[0m";
    //public static final String ANSI_BLACK = "\u001B[30m";
    //public static final String ANSI_RED = "\u001B[31m";
    //public static final String ANSI_GREEN = "\u001B[32m";
    //public static final String ANSI_YELLOW = "\u001B[33m";
    //public static final String ANSI_BLUE = "\u001B[34m";
    //public static final String ANSI_PURPLE = "\u001B[35m";
    //public static final String ANSI_CYAN = "\u001B[36m";
    //public static final String ANSI_WHITE = "\u001B[37m";
//
    //public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    //public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    //public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    //public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    //public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    //public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    //public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    //public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void newlines(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    public void printByColor(String color, String text) {
        System.out.print(color + text + Colors.ANSI_RESET);
    }

    public void printLnByColor(String color, String text) {
        System.out.println(color + text + Colors.ANSI_RESET);
    }

    public void horizontalRule() {
        System.out.println("----------------------------------------------");
    }

    public static void println(String textToPrint) {
        System.out.println(textToPrint);
    }

    public static void print(String textToPrint){
        System.out.print(textToPrint);
    }

    public void blackText(String textToPrint) {
        System.out.println(Colors.ANSI_BLACK + textToPrint + Colors.ANSI_RESET);
        System.out.println();
    }

    public static void redText(String textToPrint) {
        System.out.println(Colors.ANSI_RED + textToPrint + Colors.ANSI_RESET);
    }

    public static void purpleText(String textToPrint) {
        System.out.println(Colors.ANSI_PURPLE + textToPrint + Colors.ANSI_RESET);
    }

    public static void greenText(String textToPrint) {
        System.out.println(Colors.ANSI_GREEN + textToPrint + Colors.ANSI_RESET);
    }

    public static void yellowText(String textToPrint) {
        System.out.println(Colors.ANSI_YELLOW + textToPrint + Colors.ANSI_RESET);
    }

    public static void cyanText(String textToPrint) {
        System.out.println(Colors.ANSI_CYAN + textToPrint + Colors.ANSI_RESET);
    }

    public static void whiteText(String textToPrint) {
        System.out.println(Colors.ANSI_WHITE + textToPrint + Colors.ANSI_RESET);
    }

    public static void blueText(String textToPrint) {
        System.out.println(Colors.ANSI_BLUE + textToPrint + Colors.ANSI_RESET);
    }

    public void resetAllColor() {
        System.out.println(Colors.ANSI_RESET);
        System.out.print(Colors.ANSI_BLACK_BACKGROUND);
    }
}
