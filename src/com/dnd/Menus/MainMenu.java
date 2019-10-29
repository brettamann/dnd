package com.dnd.Menus;

import com.dnd.Utilities.Screen;

public class MainMenu {
    boolean quitProgram;

    public void displayMenu(Screen screen) {
        quitProgram = false;
        while (!quitProgram) {
            screen.clear();
            screen.print("\t\t\tMain Menu\n\n");
            screen.print("1: Change Location");
            screen.print("2: Build an encounter");
        }
    }
}
