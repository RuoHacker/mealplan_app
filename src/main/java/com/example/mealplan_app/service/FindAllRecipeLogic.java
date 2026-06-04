package com.example.mealplan_app.service;

import java.util.*;
import org.springframework.stereotype.Service;
import com.example.mealplan_app.model.RecipeDAO;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class FindAllRecipeLogic {
    
    @Autowired
    RecipeDAO recipeDAO;

    public List<Map<String, Object>> findAllRecipe(){
        // SQL文を作成
        List<Map<String, Object>> recipe = recipeDAO.findAllRecipe();
        
        return recipe;
    }
}
