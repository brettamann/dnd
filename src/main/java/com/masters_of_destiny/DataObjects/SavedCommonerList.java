package com.masters_of_destiny.DataObjects;

import java.util.List;

public class SavedCommonerList {
    String listName;
    List<Person> commoners;
    String date;
    String note;

    public SavedCommonerList(String listName, List<Person> commoners, String date, String note) {
        this.listName = listName;
        this.commoners = commoners;
        this.date = date;
        this.note = note;
    }

    public String getListName() {
        return listName;
    }

    public SavedCommonerList setListName(String listName) {
        this.listName = listName;
        return this;
    }

    public List<Person> getCommoners() {
        return commoners;
    }

    public SavedCommonerList setCommoners(List<Person> commoners) {
        this.commoners = commoners;
        return this;
    }

    public String getDate() {
        return date;
    }

    public SavedCommonerList setDate(String date) {
        this.date = date;
        return this;
    }

    public String getNote() {
        return note;
    }

    public SavedCommonerList setNote(String note) {
        this.note = note;
        return this;
    }




}
