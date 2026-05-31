package com.example.mealplan_app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;

//SQL
// import java.sql.Connection;
// import java.sql.DriverManager;
// import java.sql.Statement;
// import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.ui.Model;

import com.example.mealplan_app.model.Menu;
import com.example.mealplan_app.model.Recipe;

@Controller
public class MealplanAppController {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    
    private String[] wday = {"日", "月", "火", "水", "木","金", "土"};
    // public m_Menu menu = new m_Menu();

    @RequestMapping("/home")
    public String home(Model model){
        String sql = "SELECT * FROM recipe_table";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
        model.addAttribute("recipelist",list);
        // model.addAttribute("wday", wday);
        // model.addAttribute("recipe", recipes);
        // model.addAttribute("menu", menu);
        return "home";
    }

    @RequestMapping(value="/home", params = "random", method = RequestMethod.POST)
    public String randomSelect(Model model){
        System.out.println("PUT Random");
        String sql = "SELECT * FROM recipe_table";
        Random random = new Random();
        List<Map<String, Object>> recipelist = jdbcTemplate.queryForList(sql);


        // for(var list: recipelist){
        //     System.out.println(list.get("name"));
        // }
        List<Recipe> kondate = new ArrayList<Recipe>();
        for(int i = 0; i < 7; i++){
            int recipeNo = random.nextInt(recipelist.size());
            String recipeName = (String)recipelist.get(recipeNo).get("name");
            String recipeUrl = (String)recipelist.get(recipeNo).get("url");
            kondate.add(new Recipe(i, recipeName, recipeUrl));

        }
        model.addAttribute("recipelist", recipelist);
        model.addAttribute("kondate", kondate);
        model.addAttribute("wday", wday);

        return "home";
    }

    @RequestMapping(path="/input", method= RequestMethod.POST)
    public String recipeSubmit(@ModelAttribute("recipe") Recipe recipe, Model model){
        System.out.println(recipe.getName());
        int rowNumber = jdbcTemplate.update("INSERT INTO recipe_table(name, url) VALUES(?,?)", 
                        recipe.getName(),
                         recipe.getUrl());
        
        System.out.println(rowNumber);
        return "home";
    }
    

    @RequestMapping(path = "/input", method = RequestMethod.GET)
    public String input(Model model){
        model.addAttribute("recipe", new Recipe());
        return "input";
    }



    
}
