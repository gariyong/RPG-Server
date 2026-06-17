package com.aporia.item;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.aporia.Main;

public class MaterialManager {
    private final HashMap<String, MaterialData> materialMap = new HashMap<>();
    private FileConfiguration config;

    public MaterialManager(){
        loadConfig();
        loadMaterials();
    }

    private void loadConfig(){
        File file = new File(Main.getMain().getDataFolder(), "material.yml");

        if(!file.exists()){
            Main.getMain().saveResource("material.yml", false);
        }

       config = YamlConfiguration.loadConfiguration(file);
    }

    private void loadMaterials(){
        for(String id : config.getKeys(false)){
            String name = config.getString(id + ".name");
            if(name == null){
                Bukkit.getLogger().warning(id + "의 이름이 없습니다.");
                continue;
            }

            Material material = Material.matchMaterial(config.getString(id + ".material"));
            if(material == null){
                Bukkit.getLogger().warning(id + "의 Material이 잘못되었습니다.");
                continue;
            }

            MaterialData data = new MaterialData(id, name, material);
            materialMap.put(id, data);
        }

        Bukkit.getLogger().info("[Aporia] " + materialMap.size() + "개의 재료를 로드했습니다.");
    }
    
    public MaterialData getMaterialData(String id){
        return materialMap.get(id);
    }
}
