package com.helloandroid.yieron.yieron.model;

public class Msg {
    private static final int TYPE_RECEIVED = 0;
    private static final int TYPE_SEND = 1;

    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }

    private String content;
    private int type;

    public Msg(String content, int type) {
        this.content =content;
        this.type = type;
    }
}
