package org.generation.springbootassessment.controller.dto;

public class ItemDTO {

    private String title;
    private String description;
    private String date;

    public ItemDTO(String title, String description, String date){
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String name){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String imageUrl){
        this.date = date;
    }
}
