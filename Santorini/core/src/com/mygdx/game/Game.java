package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.io.IOException;
import java.util.Scanner;

public class Game implements ApplicationListener {
    public static final int TILE = 65;
    private Map map;
    private Sprite[][] sprites;
    private Texture tile;
    private Texture charactor;
    private SpriteBatch batch;
    private Unit unit;

    public void showMap(){
        for (int i=0;i<map.getWidth();i++){
            for (int j=0;j<map.getHeight();j++){
                System.out.print(map.getMap()[j][i]);
            }
            System.out.print('\n');
        }
    }


    @Override
    public void create() {
        batch = new SpriteBatch();
        map = new Map(5,5);
        sprites = new Sprite[map.getWidth()][map.getHeight()];
        tile = new Texture(Gdx.files.internal("stein2.png"));
        charactor = new Texture(Gdx.files.internal("crt.png"));
        unit = new Unit(0,1,1,true,map);
        map.addUnit(unit);

        updateSprite();
    }

    private void updateSprite(){
        for (int i=0;i<map.getHeight();i++){
            for (int j=0;j<map.getWidth();j++){
                switch (map.getTile(i,j)){
                    case 0: sprites[i][j] = new Sprite(tile);
                        break;
                    case 9: sprites[i][j] = new Sprite(charactor);
                        break;
                }
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0.57f, 0.77f, 0.85f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
            System.out.println("x: "+ Gdx.input.getX()+" , y: "+Gdx.input.getY());
        }
        batch.begin();
        updateSprite();
        for (int i=0;i<map.getHeight();i++){
            for (int j=0;j<map.getWidth();j++){
                System.out.println("x: "+ i*TILE+" , y: "+j*TILE);
                sprites[i][j].setPosition(i*TILE,j*TILE);
                sprites[i][j].draw(batch);
            }
        }
        batch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }
}
