package com.mygdx.game;

public class Block extends Entity{
    private Map map;
    private int level;

    public Block(int x, int y, int level, Map map) {
        super(x,y);
        this.map = map;
        if (map.getTile(x,y)!=Map.BLOCK_LEVEL_1 && map.getTile(x,y)!=Map.BLOCK_LEVEL_2 && map.getTile(x,y)!=Map.BLOCK_LEVEL_3 && map.getTile(x,y)!=Map.BLOCK_LEVEL_4){
            this.x = x;
            this.y = y;
        }
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean increaseLevel(){
        if (level<Map.BLOCK_LEVEL_4){
            level++;
            return true;
        }
        else return false;
    }
}
