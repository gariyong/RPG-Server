package com.aporia.crafting;

import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.aporia.Main;
import com.aporia.item.EquipmentData;
import com.aporia.item.MaterialData;

public class CraftManager {
    public int getMaterialCount(Player player, String materialId){
        int count = 0;

        for(ItemStack item : player.getInventory().getContents()){
            if(item == null){
                continue;
            }

            String itemId = Main.getMain().getCustomItemManager().getItemId(item);
            if(itemId == null){
                continue;
            }

            if(!itemId.equals(materialId)){
                continue;
            }

            count += item.getAmount();
        }

        return count;
    }

    public boolean canCraft(Player player, RecipeData recipe){
        for(Map.Entry<String, Integer> entry : recipe.getMaterials().entrySet()){
            String materialId = entry.getKey();
            int required = entry.getValue();
            int current = getMaterialCount(player, materialId);

            if(current < required){
                return false;
            }
        }

        return true;
    }

    public void removeMaterials(Player player, RecipeData recipe){
        for(Map.Entry<String, Integer> entry : recipe.getMaterials().entrySet()){
            String materialId = entry.getKey();
            int remain = entry.getValue();

            for(ItemStack item : player.getInventory().getContents()){
                if(item == null){
                    continue;
                }

                String itemId = Main.getMain().getCustomItemManager().getItemId(item);
                if(itemId == null){
                    continue;
                }

                if(!itemId.equals(materialId)){
                    continue;
                }

                if(item.getAmount() <= remain){
                    remain -= item.getAmount();
                    item.setAmount(0);
                }else{
                    item.setAmount(item.getAmount() - remain);
                    remain = 0;
                }

                if(remain <= 0){
                    break;
                }
            }
        }
    }

    public boolean craft(Player player, String recipeId){
        RecipeData recipe = Main.getMain().getRecipeManager().getRecipe(recipeId);
        if(recipe == null){
            return false;
        }

        if(!canCraft(player, recipe)){
            return false;
        }

        removeMaterials(player, recipe);
        String resultId = recipe.getResultId();

        EquipmentData equipment = Main.getMain().getEquipmentManager().getEquipmentData(resultId);
        if(equipment != null){
            ItemStack item = Main.getMain().getCustomItemManager().createEquipment(equipment);
            item.setAmount(recipe.getAmount());
            player.getInventory().addItem(item);

            return true;
        }

        MaterialData material = Main.getMain().getMaterialManager().getMaterialData(resultId);
        if(material != null){
            ItemStack item = Main.getMain().getCustomItemManager().createMaterial(material);
            item.setAmount(recipe.getAmount());

            player.getInventory().addItem(item);

            return true;
        }

        return false;
    }
}
