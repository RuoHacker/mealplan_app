package com.example.mealplan_app.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.mealplan_app.model.RecipeDAO;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.mealplan_app.model.Recipe;

@Service
public class DeleteRecipeLogic {
    
    @Autowired
    RecipeDAO recipeDAO;

    public boolean deleteRecipe(Recipe recipe){
        return recipeDAO.deleteRecipe(recipe);
    }
}
