package com.hotel;

public enum City {

    Beijing("北京"),
    London("伦敦"),
    Moscow("莫斯科"),
    Sydney("悉尼"),
    NewYork("纽约");

    private String name;
    public String getName() {
        return name;
    }

    City(String name) {
        this.name = name;
    }
}
