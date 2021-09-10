package com.movie.vo;

public class Msg {
    String data;

    public Msg() {}

    public Msg(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "data='" + data + '\'' +
                '}';
    }
}
