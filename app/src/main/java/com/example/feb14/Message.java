package com.example.feb14;

import java.util.ArrayList;

public class Message {
    public String message;
    public String timestamp;
    public Boolean isImage = Boolean.FALSE;
    public String id;

    public Message() {

    }

    public Message(String message, String id, String timestamp, Boolean isImage) {
        this.message = message;
        this.timestamp = timestamp;
        this.id = id;
        this.isImage = isImage;
    }

    public String getTimestamp(){return timestamp;}
    public String getMessage() {
        return message;
    }
    public String getId() {return id;}
    public Boolean getIsImage(){return isImage;}

    public void setMessage(String message) {this.message = message;}
    public void setTimestamp(String timestamp){this.timestamp = timestamp;}
    public  void setIsImage(Boolean isImage){this.isImage = isImage;}
    public void setId(String id) {this.id = id;}
}
