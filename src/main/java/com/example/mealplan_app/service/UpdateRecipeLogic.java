package com.example.mealplan_app.service;

import org.springframework.stereotype.Service;
import com.example.mealplan_app.model.RecipeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mealplan_app.model.Recipe;

@Service
public class UpdateRecipeLogic {
    
    @Autowired
    RecipeDAO recipeDAO;

    public boolean updateRecipe(Recipe recipe){
        return recipeDAO.updateRecipe(recipe);
    }
}
