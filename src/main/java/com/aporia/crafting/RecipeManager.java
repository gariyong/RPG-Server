package com.aporia.crafting;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.aporia.Main;

public class RecipeManager {
    private final HashMap<String, RecipeData> recipeMap = new HashMap<>();
    private FileConfiguration config;

    public RecipeManager(){
        loadConfig();
        loadRecipes();
    }

    private void loadConfig(){
        File file = new File(Main.getMain().getDataFolder(), "recipe.yml");
        if(!file.exists()){
            Main.getMain().saveResource("recipe.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(file);
    }

    private void loadRecipes(){
        for(String id : config.getKeys(false)){
            String resultId = config.getString(id + ".result");
            int amount = config.getInt(id + ".amount");
            ConfigurationSection section = config.getConfigurationSection(id + ".materials");

            if(section == null){
                continue;
            }

            HashMap<String, Integer> materials = new HashMap<>();
            for(String materialId : section.getKeys(false)){
                materials.put(materialId, section.getInt(materialId));
            }

            RecipeData recipe = new RecipeData(resultId, amount, materials);
            recipeMap.put(id, recipe);
        }

        Bukkit.getLogger().info("[Aporia] " + recipeMap.size() + "개의 레시피를 로드했습니다.");
    }

    public RecipeData getRecipe(String id){
        return recipeMap.get(id);
    }
}
