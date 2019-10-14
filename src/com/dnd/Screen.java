package com.dnd;

public class Screen {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    public void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void newlines(int lines) {
        for (int i = 0; i < lines; i++) {
            System.out.println();
        }
    }

    public void horizontalRule() {
        System.out.println("----------------------------------------------");
    }

    public void print(String textToPrint) {
        System.out.println(textToPrint);
    }

    public void blackText(String textToPrint) {
        System.out.println(ANSI_BLACK + textToPrint + ANSI_RESET);
        System.out.println();
    }

    public void redText(String textToPrint) {
        System.out.println(ANSI_RED + textToPrint + ANSI_RESET);
    }

    public void purpleText(String textToPrint) {
        System.out.println(ANSI_PURPLE + textToPrint + ANSI_RESET);
    }

    public void greenText(String textToPrint) {
        System.out.println(ANSI_GREEN + textToPrint + ANSI_RESET);
    }

    public void yellowText(String textToPrint) {
        System.out.println(ANSI_YELLOW + textToPrint + ANSI_RESET);
    }

    public void cyanText(String textToPrint) {
        System.out.println(ANSI_CYAN + textToPrint + ANSI_RESET);
    }

    public void whiteText(String textToPrint) {
        System.out.println(ANSI_WHITE + textToPrint + ANSI_RESET);
    }

    public void blueText(String textToPrint) {
        System.out.println(ANSI_BLUE + textToPrint + ANSI_RESET);
    }

    public void resetAllColor() {
        System.out.println(ANSI_RESET);
        System.out.print(ANSI_BLACK_BACKGROUND);
    }
}
