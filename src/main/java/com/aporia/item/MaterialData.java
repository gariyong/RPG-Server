package com.aporia.item;

import org.bukkit.Material;

public class MaterialData {
    private final String id;
    private final String name;
    private final Material material;

    public MaterialData(String id, String name, Material material){
        this.id = id;
        this.name = name;
        this.material = material;
    }

    public String getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Material getMaterial(){
        return material;
    }
}
