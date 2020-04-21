package models;

import javafx.util.Pair;

import java.util.ArrayList;

import java.util.List;

public class Currency {
    private long id;
    private String name; // в валюту
    private List<Pair<String, Double>> value; // пара значений. Дата и стоимость

    public Currency(long id, String name,List<Pair<String, Double>> value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Pair<String, Double>> getValue() {
        return value;
    }

    public void setId(long param1) {
        this.id = param1;
    }

    public void setName(String name) {
        this.name = name;
    }

}
