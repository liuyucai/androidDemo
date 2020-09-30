package com.example.project2.model;

public class ChatMsg {
    public static final int TYPE_RECEIVE = 1;

    public static final int TYPE_SEND = 2;
    private String content = "刘宇才";
    private int type = 2;

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
