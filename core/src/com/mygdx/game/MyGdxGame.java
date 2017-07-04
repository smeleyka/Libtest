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
    Asteroid ast;
    Player player;
    static Bullet bullet;
    final int asteroidCount = 10;
    Asteroid[] astArr;


    @Override
    public void create() {
        batch = new SpriteBatch();
        bullet = new Bullet();
        player = new Player();
        ast = new Asteroid(200f, 150f, 1f);
        astArr = new Asteroid[asteroidCount];
        for (int i = 0; i < astArr.length; i++) {
            astArr[i] = new Asteroid();
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(255, 255, 255, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        update();
        batch.begin();

        for (int i = 0; i < astArr.length; i++) {
            astArr[i].render(batch);
        }
        ast.render(batch);
        player.render(batch);
        batch.end();
    }

    public void update() {
        player.update(Gdx.graphics.getDeltaTime());
        ast.update(Gdx.graphics.getDeltaTime());
        for (int i = 0; i < astArr.length; i++) {
            astArr[i].update(Gdx.graphics.getDeltaTime());
        }
    }


    @Override
    public void dispose() {
        batch.dispose();
    }
}
