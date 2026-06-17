package com.aporia.crafting;

import java.util.HashMap;

public class RecipeData {
    private final String resultId;
    private final int amount;

    private final HashMap<String,Integer> materials;

    public RecipeData(String resultId, int amount, HashMap<String,Integer> materials){
        this.resultId = resultId;
        this.amount = amount;
        this.materials = materials;
    }

    public String getResultId(){
        return resultId;
    }

    public int getAmount(){
        return amount;
    }

    public HashMap<String,Integer> getMaterials(){
        return materials;
    }
}
