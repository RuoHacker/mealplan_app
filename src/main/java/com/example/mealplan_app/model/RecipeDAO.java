package com.example.mealplan_app.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RecipeDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //リポジトリからレシピを削除する関数
    public void deleteRecipe(Recipe recipe){
        
    }
    //リポジトリにレシピを挿入する関数
    public void insertRecipe(Recipe recipe){
        
    }

    //リポジトリから引数で探したレシピを探す関数
    public Map<String, Object> findRecipe(int id){

        String query = """
                SELECT * FROM recipe_table WHERE user_id=? 
                """;

        Map<String, Object> recipe = jdbcTemplate.queryForMap(query,id);

        return recipe;
    }

}
