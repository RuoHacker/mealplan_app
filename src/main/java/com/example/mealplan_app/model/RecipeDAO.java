package com.example.mealplan_app.model;

import java.util.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class RecipeDAO {
    @Autowired
    public JdbcTemplate jdbcTemplate;

    public RecipeDAO(){
    }

    //リポジトリからレシピを削除する関数
    public boolean deleteRecipe(Recipe recipe){
        String query = """
                DELETE FROM recipe_table WHERE id=?
                """;
        int isDeleted = jdbcTemplate.update(query, recipe.getId());
        return isDeleted > 0;
    }
    //リポジトリにレシピを挿入する関数
    public boolean insertRecipe(Recipe recipe){
        String query = """
                INSERT INTO recipe_table (id, name, url)
                VALUES (?, ?)
                """;
        int isInserted = jdbcTemplate.update(query,recipe.getName(), recipe.getUrl());
        return isInserted > 0;
    }

    //リポジトリから引数で探したレシピを探す関数
    public Map<String, Object> findRecipe(int id){

        String query = """
                SELECT * FROM recipe_table WHERE id=? 
                """;

        Map<String, Object> recipe = jdbcTemplate.queryForMap(query,id);

        return recipe;
    }

    public List<Map<String, Object>> findAllRecipe(){
        String query = """
                SELECT * FROM recipe_table""";

        List<Map<String, Object>> recipe = jdbcTemplate.queryForList(query);
        return recipe;
    }
}
