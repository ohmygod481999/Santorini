package com.mygdx.game;

import java.util.ArrayList;
import java.util.List;

public class Map {
    public static final int EMPTY = 0;
    public static final int UNIT = 9;
    public static final int BLOCK_LEVEL_1 = 1;
    public static final int BLOCK_LEVEL_2 = 2;
    public static final int BLOCK_LEVEL_3 = 3;
    public static final int BLOCK_LEVEL_4 = 4;

    private int width;
    private int height;
    private int[][] map;
    private List<Unit> units;
    private List<Block> blocks;

    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new int[width][height];
        units = new ArrayList<Unit>();
        blocks = new ArrayList<Block>();
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getMap() {
        return map;
    }

    public void setMap(int[][] map) {
        this.map = map;
    }

    public int getTile(int x,int y){
        return map[x][y];
    }

    public Block getBlock(int x,int y){
        if (map[x][y]>=BLOCK_LEVEL_1 && map[x][y]<=BLOCK_LEVEL_4){
            for (Block block : blocks){
                if (block.getX()==x && block.getY()==y) return block;
            }
        }
        return null;
    }

    public void addUnit(Unit unit){
        int x = unit.getX();
        int y = unit.getY();

        map[x][y] = 9;
        units.add(unit);
    }

    public void addBlock(Block block){
        int x = block.getX();
        int y = block.getY();

        map[x][y] = block.getLevel();
        blocks.add(block);
    }

    public void update(){
        for (int i=0;i<height;i++){
            for (int j=0;j<width;j++){
                map[i][j]=0;
            }
        }
        for (Unit unit : units){
            map[unit.getX()][unit.getY()]=9;
        }
    }

    /*public void moveUnit(int i, Unit unit){
        switch (i){
            case 4:
                unit.moveTo(unit.getX()-1,unit.getY());
                break;
            case 7:
                unit.moveTo(unit.getX()-1,unit.getY()-1);
                break;
            case 9:
                unit.moveTo(unit.getX()+1,unit.getY()-1);
                break;
            case 1:
                unit.moveTo(unit.getX()-1,unit.getY()+1);
                break;
            case 3:
                unit.moveTo(unit.getX()+1,unit.getY()+1);
                break;
            case 6:
                unit.moveTo(unit.getX()+1,unit.getY());
                break;
            case 8:
                unit.moveTo(unit.getX(),unit.getY()-1);
                break;
            case 2:
                unit.moveTo(unit.getX(),unit.getY()+1);
                break;
        }
    }

    public void update(){
        for (int i=0;i<width;i++){
            for (int j=0;j<height;j++) map[i][j]=0;
        }
        for(Unit unit : units){
            int x = unit.getX();
            int y = unit.getY();

            map[x][y] = 9;
        }
    }*/

    public List<Unit> getUnits() {
        return units;
    }
}
