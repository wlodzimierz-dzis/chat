package com.chat.model.objects;

public class Contacts {
    private int contact_id;
    private String phonebook_ref;
    private String user_id_server;

    public Contacts(String phonebook, String user_serverid) {
        this.phonebook_ref = phonebook;
        this.user_id_server = user_serverid;
    }

    public Contacts(int id, String phonebook, String user_serverid) {
        this.contact_id = id;
        this.phonebook_ref = phonebook;
        this.user_id_server = user_serverid;
    }

    public int getId() {
        return contact_id;
    }
    public void setId(int id){
        this.contact_id = id;
    }

    public String getPhonebook() {
        return phonebook_ref;
    }

    public String getUserServer() {
        return user_id_server;
    }

    /*public String toString() {
        return name;
    }*/
}

