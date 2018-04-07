package com.example.focus.listapp;

public class Contact {
    public Contact(int image_id, String name, String shortDescription){
        this.setImage_id(image_id);
        this.setName(name);
        this.setShortDescription(shortDescription);
    }

    private int image_id;
    private String name, shortDescription;

    public int getImage_id(){
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDescription(){
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
