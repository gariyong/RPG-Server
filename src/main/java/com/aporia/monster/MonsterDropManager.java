package com.aporia.monster;

import java.util.ArrayList;
import java.util.List;

public class MonsterDropManager {
    private List<DropData> level10Drops = new ArrayList<>();

    public MonsterDropManager(){
        level10Drops.add(new DropData("iron_sword", 10));
        level10Drops.add(new DropData("iron_helmet", 10));
        level10Drops.add(new DropData("iron_armor", 10));
    }

    public List<DropData> getDrops(int level){
        if(level == 10){
            return level10Drops;
        }

        return null;
    }
}
