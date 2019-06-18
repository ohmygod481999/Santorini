package com.mygdx.game;

public class Unit extends Entity implements CanMove,CanBuild {

    private Map map;
    private boolean isMale;
    private int step;

    public Unit(int x, int y, int step,boolean isMale, Map map) {
        super(x,y);
        this.step = step;
        this.isMale = isMale;
        this.map = map;
    }


    public int stepsMoveTo(int x, int y) {
        int dX = Math.abs(this.x - x);
        int dY = Math.abs(this.y - y);
        if (dX>=dY) return dX;
        return dY;
    }

    @Override
    public boolean canMove(int x, int y) {
        if ( x>=0 && x<map.getWidth() && y>=0 && y<map.getWidth()){
            if (step>=stepsMoveTo(x,y)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void moveTo(int x, int y) {
        if (canMove(x,y)){
            this.x = x;
            this.y = y;
            map.update();
        }
    }

    @Override
    public boolean canBuild(int x, int y) {
        int steps = stepsMoveTo(x,y);
        if (steps==1){
            if(x>=0 && x<map.getWidth() && y>=0 && y<map.getWidth()){
                if (map.getTile(x,y)<Map.BLOCK_LEVEL_4){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void build(int x, int y) {
        if (canBuild(x,y)){
            int blockLevel = map.getTile(x,y);
            if (blockLevel==0) map.addBlock(new Block(x,y,0,map));
            else{
                Block block = map.getBlock(x,y);
                if (block != null) block.increaseLevel();
            }
        }
    }
}
