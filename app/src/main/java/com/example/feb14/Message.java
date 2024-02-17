package com.example.feb14;

import java.util.ArrayList;

public class Message {
    public String message;
    public String timestamp;
    public String id;

    public Message() {

    }

    public Message(String message, String id, String timestamp) {
        this.message = message;
        this.timestamp = timestamp;
        this.id = id;
    }

    public String getTimestamp(){return timestamp;}
    public String getMessage() {
        return message;
    }
    public String getId() {return id;}

    public void setMessage(String message) {this.message = message;}
    public void setTimestamp(String timestamp){this.timestamp = timestamp;}
    public void setId(String id) {this.id = id;}
}
