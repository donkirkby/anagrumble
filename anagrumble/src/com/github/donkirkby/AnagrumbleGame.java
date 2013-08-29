package com.github.donkirkby;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class AnagrumbleGame implements ApplicationListener {
	private Stage stage;
	private TextButton button;
	
	@Override
	public void create() {		
		Skin skin = new Skin(Gdx.files.internal("data/uiskin.json"));
		
		stage = new Stage();
		button = new TextButton("Click Me!", skin);
		stage.addActor(button);
		button.addListener(new ClickListener() {
		    @Override
		    public void clicked(InputEvent event, float x, float y) {
		        button.setText("Clicked!");
		    }
		});
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void dispose() {
		stage.dispose();
	}

	@Override
	public void render() {		
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
	}

	@Override
	public void resize(int width, int height) {
	    button.setPosition(
	            (width-button.getWidth())/2, 
	            (height-button.getHeight())/2);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}
}
