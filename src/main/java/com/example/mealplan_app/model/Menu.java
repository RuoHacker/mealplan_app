package com.example.mealplan_app.model;
import lombok.Data;

@Data
public class Menu {
    String[] wday = {"月","火","水","木","金","土","日"};
    Recipe[] recipes;

    public Menu(){
        this.recipes = new Recipe[7];
        // for(int i=0; i<this.recipes.length; i++){
        //     this.recipes[i] = new Recipe();
        // }
    }
}
