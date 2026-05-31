package com.example.mealplan_app.model;
import lombok.Data;



@Data
public class Recipe {
    private final String[] wday = {"日", "月", "火", "水", "木","金", "土"};
    private int id;
    private int wid;
    private String name;
    private String url;

    public Recipe(){
        this.id = 0;
        this.wid = 0;
        this.name = "";
        this.url = "";
    }
    public Recipe(int id, String name, String url){
        this.id = id;
        this.name = name;
        this.url = url;
    }

    public String getWday(){
        return this.wday[this.id];
    }
}

