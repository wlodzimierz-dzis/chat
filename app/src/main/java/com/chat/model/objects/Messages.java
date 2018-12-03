package com.chat.model.objects;

public class Messages {
    private int message_id;
    private int contact_id;
    private int conversation_id;
    private String content;
    private String geolocation;

    public Messages(String content, String geolocation, int contact_id, int conversation_id) {
        this.content = content;
        this.geolocation = geolocation;
        this.contact_id = contact_id;
        this.conversation_id = conversation_id;
    }

    public int getId() {
        return message_id;
    }
    public void setId(int id)  { this.message_id = id; }

    public String getContent() {
        return content;
    }
    public String getGeolocation() {
        return geolocation;
    }
    public int getContact() {
        return contact_id;
    }
    public int getConversation() {
        return conversation_id;
    }

    public String toString() {
        return  content + ' ' + geolocation ;
    }
}

