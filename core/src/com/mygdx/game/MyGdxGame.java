package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.print.attribute.AttributeSet;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Texture imgFire;
	TextureRegion ship;
	TextureRegion fire;
	TextureRegion[] fireFrame;
	TextureRegion currentFrame;
	Animation fireAnimation;
	int FIRE_ROWS=4;
	int FIRE_COLUMNS=5;
	int shipWight = 73;
	int shipHeight = 102;
	int count=0;
	int fireCount=0;
	float stateTime;
	float scrollX=0;
	float scrollY=0;
	Asteroid ast;
	Asteroid[] astArr;



	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("ship.png");
		imgFire = new Texture("fire.png");
		ship = new TextureRegion(img,0,img.getHeight()/4*3,shipWight,shipHeight);
		fire = new TextureRegion(imgFire,0,0,imgFire.getWidth()/5,imgFire.getHeight()/4);
		TextureRegion[][] tmp = TextureRegion.split(imgFire,imgFire.getWidth()/FIRE_COLUMNS,imgFire.getHeight()/FIRE_ROWS);
		fireFrame = new TextureRegion[FIRE_ROWS*FIRE_COLUMNS];
		int index = 0;
		for (int i = 0; i < tmp.length; i++) {
			for (int j = 0; j < tmp[i].length; j++) {
				fireFrame[index++]=tmp[i][j];
			}

		}
		fireAnimation = new Animation(0.05f,fireFrame);
		stateTime = 0f;

		ast = new Asteroid(200f,150f,1f);

		astArr = new Asteroid[50];
		for (int i = 0; i < astArr.length; i++) {
			astArr[i] = new Asteroid();

		}



	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(255, 255, 255, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime+=Gdx.graphics.getDeltaTime();

		update();
		batch.begin();
		batch.draw(currentFrame,150,150);
		batch.draw(ship,0,0);
		for (int i = 0; i < astArr.length; i++) {
			astArr[i].render(batch);
		}
		ast.render(batch);

		batch.end();
	}

	//@Override
	public void update(){


		if(count>6) count = 0;
		ship.setRegion(count*shipWight,img.getHeight()/4*3,shipWight,shipHeight);
		count+=1;

		if(fireCount>20) fireCount=0;
		fire.setRegion(imgFire.getHeight()/4*3,0,shipWight,shipHeight);

		currentFrame = (TextureRegion)fireAnimation.getKeyFrame(stateTime,true);

		ast.update(Gdx.graphics.getDeltaTime());

		for (int i = 0; i < astArr.length; i++) {
			astArr[i].update(Gdx.graphics.getDeltaTime());

		}




	}



	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
