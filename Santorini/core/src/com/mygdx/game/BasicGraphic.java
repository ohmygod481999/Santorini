package com.mygdx.game;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class BasicGraphic implements ApplicationListener {
    public static final int TILE = 65;
    private SpriteBatch batch;
    private Pixmap pixmap;
    private Texture texture;
    private Texture texture2;
    private Sprite sprite;
    private Sprite sprite2;
    private Sprite sprite3;
    private Animation<TextureAtlas.AtlasRegion> animation;
    private float eTime = 0;

    private TextureAtlas textureAtlas;
    private  int currentFrame = 1;
    private  String currentAtlasKey = new String("dante");
    private Sprite[][] sprites;

    @Override
    public void create() {
        batch = new SpriteBatch();
        pixmap = new Pixmap(256,256,Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.RED);
        pixmap.fill();
        pixmap.setColor(Color.BLACK);
        pixmap.drawLine(0,0,pixmap.getWidth()/2,pixmap.getHeight());
        pixmap.setColor(Color.BLUE);
        pixmap.drawCircle(pixmap.getWidth()/2,pixmap.getHeight()/2,50);

        textureAtlas = new TextureAtlas(Gdx.files.internal("spritesheet.atlas"));
        TextureAtlas.AtlasRegion region = textureAtlas.findRegion(currentAtlasKey);
        animation = new Animation<TextureAtlas.AtlasRegion>(1/5.0f, textureAtlas.getRegions());
        sprite3 = new Sprite(region);
        sprite3.setPosition(120,100);

        texture = new Texture(Gdx.files.internal("stein2.png"));
        texture2 = new Texture(pixmap);
        sprite = new Sprite(texture2);
        sprite2 = new Sprite(texture);
        sprites = new Sprite[5][5];
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                sprites[i][j] = new Sprite(texture);
                sprites[i][j].setPosition(i*TILE,j*TILE);
            }
        }


    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();
//        sprite.draw(batch);
//        sprite2.draw(batch);
        for (int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                sprites[i][j].draw(batch);
            }
        }
//        eTime +=Gdx.graphics.getDeltaTime();
//        batch.draw(animation.getKeyFrame(eTime,true),0,0);
        //sprite3.draw(batch);
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        texture.dispose();
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }
}