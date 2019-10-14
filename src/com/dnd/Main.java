package com.dnd;

public class Main {

    public static void main(String[] args) {
        Screen screen = new Screen();
        Input input = new Input();
        PartyInfo partyInfo = new PartyInfo();
        Database database = new Database();
        database.createNewDatabase("bastion.db");
        screen.redText("this should be red");
        screen.print("this is just printed");
        screen.cyanText("this should be cyan");
        screen.print("ready for some input?");
        input.promptTextInput("Enter something here!@!!");
        input.readInputText();
    }
}
