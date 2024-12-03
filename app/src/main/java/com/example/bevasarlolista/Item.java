package com.example.bevasarlolista;

public class Item {
    private String Name;
    private int ar;

    public Item(String name, int ar) {
        Name = name;
        this.ar = ar;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAr() {
        return ar;
    }

    public void setAr(int ar) {
        this.ar = ar;
    }
}
