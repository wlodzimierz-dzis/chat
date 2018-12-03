package com.chat.model.objects;

import java.util.ArrayList;

public class Conversations {
    private int conversation_id;
    private String name;
    private ArrayList<Messages> messages = new ArrayList<>();

    public Conversations(String name, ArrayList<Messages> messages) {
        this.name = name;
        this.messages = (messages != null) ? messages : new ArrayList<Messages>();
    }

    public int getId() {
        return conversation_id;
    }
    public void setId(int id)  { this.conversation_id = id; }

    public String getName() {
        return name;
    }
    public ArrayList<Messages> getGroups() {
        return messages;
    }

    /*public String toString() {
        return id + ". " + name + ' ' + surname ;
    }*/
}
