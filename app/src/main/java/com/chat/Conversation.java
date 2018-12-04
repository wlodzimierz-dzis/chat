package com.chat;

import java.util.ArrayList;

public class Conversation {
    private String name;
    private String surname;

    public Conversation(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public String toString(){
        return this.name + " " + this.surname;
    }

    public static ArrayList<Conversation> getExampleStudentsList() {
        ArrayList<Conversation> students = new ArrayList<>();
        for(int i=0; i<4; i++) {
            students.add(new Conversation("Kamil", "Kosiński"));
            students.add(new Conversation("Tomasz", "Grembosz"));
            students.add(new Conversation("Włodzimierz", "Dziś"));
        }
        return students;
    }
}
