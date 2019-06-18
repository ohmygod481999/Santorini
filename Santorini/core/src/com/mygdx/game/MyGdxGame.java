package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

public class MyGdxGame extends ApplicationAdapter {
	OrthographicCamera camera;
	ExtendViewport viewport;
	SpriteBatch batch;
	Texture img;
	float x , y;
	
	@Override
	public void create () {
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(800,600,camera);
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.57f, 0.77f, 0.85f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if (Gdx.input.isButtonPressed(Input.Keys.NUM_0)){
			y = y + 4;
		}
		batch.begin();
		batch.draw(img, x, y);
		batch.end();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width,height,true);

		batch.setProjectionMatrix(camera.combined);
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
