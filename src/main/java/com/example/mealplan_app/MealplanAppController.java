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

import com.example.mealplan_app.model.Recipe;
import com.example.mealplan_app.service.*;

@Controller
public class MealplanAppController {
    @Autowired
    FindAllRecipeLogic findAllRecipeLogic;
    @Autowired
    InsertRecipeLogic insertRecipeLogic;
    @Autowired
    DeleteRecipeLogic deleteRecipeLogic;

    private String[] wday = {"日", "月", "火", "水", "木","金", "土"};
    // public m_Menu menu = new m_Menu();

    @RequestMapping("/home")
    public String home(Model model){
        
        List<Map<String, Object>> list = findAllRecipeLogic.findAllRecipe();
        model.addAttribute("recipelist",list);
        // model.addAttribute("wday", wday);
        // model.addAttribute("recipe", recipes);
        // model.addAttribute("menu", menu);
        return "home";
    }

    @RequestMapping(value="/home", params = "random", method = RequestMethod.POST)
    public String randomSelect(Model model){
        Random random = new Random();
        List<Map<String, Object>> recipelist = findAllRecipeLogic.findAllRecipe();


        // for(var list: recipelist){
        //     System.out.println(list.get("name"));
        // }
        List<Recipe> kondate = new ArrayList<Recipe>();
        for(int i = 0; i < 7; i++){
            int recipeNo = random.nextInt(recipelist.size());
            String recipeName = (String)recipelist.get(recipeNo).get("name");
            String recipeUrl = (String)recipelist.get(recipeNo).get("url");
            kondate.add(new Recipe(recipeName, recipeUrl));

        }
        model.addAttribute("recipelist", recipelist);
        model.addAttribute("kondate", kondate);
        model.addAttribute("wday", wday);

        return "home";
    }

    @RequestMapping(path="/input", method= RequestMethod.POST)
    public String recipeSubmit(@ModelAttribute("recipe") Recipe recipe, Model model){
        System.out.println(recipe.getName());
        boolean isInserted = insertRecipeLogic.insertRecipe(new Recipe(recipe.getName(), recipe.getUrl()));
        
        return "redirect:home";
    }
    

    @RequestMapping(path = "/input", method = RequestMethod.GET)
    public String input(Model model){
        model.addAttribute("recipe", new Recipe());
        return "input";
    }



    
}
