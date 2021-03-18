package com.example.project2.model;

public class ChatMsg {
    public static final int TYPE_RECEIVE = 1;

    public static final int TYPE_SEND = 2;
//    后面为android原生表情
    private String content = "刘宇才\uD83D\uDE01";
    private int type = 1;

    public ChatMsg(){

    }

    public ChatMsg(int type,String content){
        this.type = type;
        this.content = content;
    }

    public int getType() {
        return type;
    }

    public String getContent() {
        return content;
    }
}
