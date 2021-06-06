package org.generation.springbootassessment.repository.Entity;

import org.generation.springbootassessment.controller.dto.ItemDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String description;
    private String date;

    public Item(){}

    //Task 9
    public Item( ItemDTO itemDto ){
        this.title = itemDto.getTitle();
        this.description = itemDto.getDescription();
        this.date = itemDto.getDate();
    }

    //overloading constructor
    public Item(String title, String description, String date)
    {
        this.title = title;
        this.description = description;
        this.date = date;
    }

    public Integer getId(){
        return id;
    }

    public void SetId( Integer id){
        this.id = id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle ( String title){
        this.title = title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription( String description ){
        this.description = description;
    }

    public String getDate(){
        return date;
    }

    public void setDate(String date){
        this.date = date;
    }

    @Override
    public String toString(){
        return "Item{" + "id=" + ", title='" + title + '\'' + ", description'" + description + '\'' + ", date='" + date + '\'' + '}';
    }

}
