package com.lyy.cart.bean;

public class User {
    private int id;
    private String name;
    private String passWord;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassWord() {
        return passWord;
    }
}