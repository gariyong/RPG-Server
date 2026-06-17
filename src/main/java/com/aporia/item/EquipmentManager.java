package com.aporia.item;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.aporia.Main;

public class EquipmentManager {
  private final HashMap<String, EquipmentData> equipmentMap = new HashMap<>();

  private FileConfiguration config;

  public EquipmentManager(){
        loadConfig();
        loadEquipment();
  }

  private void loadConfig(){
        File file = new File(Main.getMain().getDataFolder(), "equipment.yml");

        if(!file.exists()){
                Main.getMain().saveResource("equipment.yml", false);
        }

        config = YamlConfiguration.loadConfiguration(file);
  }

  private void loadEquipment(){
        for(String id : config.getKeys(false)){
                String name = config.getString(id + ".name");

                String typeName = config.getString(id + ".type");
                EquipmentType type;

                Rarity rarity = Rarity.valueOf(config.getString(id + ".rarity"));

                try{
                        type = EquipmentType.valueOf(typeName);
                }catch(Exception e){
                        Bukkit.getLogger().warning(id + "의 EquipmentType이 잘못되었습니다.");
                        continue;
                }
                
                Material material = Material.matchMaterial(config.getString(id + ".material"));

                if(material == null){
                        Bukkit.getLogger().warning(id + "의 Material이 잘못되었습니다.");
                        continue;
                }

                int attack = config.getInt(id + ".attack");
                int defense = config.getInt(id + ".defense");

                int maxHealth = config.getInt(id + ".max-health");

                double critChance = config.getDouble(id + ".crit-chance");
                double critDamage = config.getDouble(id + ".crit-damage");

                EquipmentData data 
                        = new EquipmentData(
                                id, 
                                name, 
                                type, 
                                rarity, 
                                material, 
                                attack, 
                                defense, 
                                maxHealth, 
                                critChance, 
                                critDamage
                        );

                equipmentMap.put(id, data);
        }
        
                Bukkit.getLogger().info("[Aporia] " + equipmentMap.size() + "개의 장비를 로드했습니다.");
  }

  // 장비 조회
  public EquipmentData getEquipmentData(String id){
    return equipmentMap.get(id);
  }

}
