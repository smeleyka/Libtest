package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import javax.swing.*;

/**
 * Created by smeleyka on 30.06.17.
 */
public class Asteroid {
    Texture texture;
    TextureRegion textureRegion;
    float x, y;
    float vx, vy;
    float w, h;
    float r;
    float scale;
    float rotate;
    float vrotate;

    public Asteroid(float vx, float vy,float scale) {
        this.texture = new Texture("asteroid.png");
        this.textureRegion = new TextureRegion(texture);
        this.scale = scale;
        this.vx = vx;
        this.vy = vy;
        this.x = Gdx.graphics.getWidth() / 2;
        this.y = Gdx.graphics.getHeight() / 2;
        this.w = texture.getWidth();
        this.h = texture.getHeight();
        this.r = w / 2*scale;
    }
    public Asteroid() {
        this.texture = new Texture("asteroid.png");
        this.textureRegion = new TextureRegion(texture);
        this.scale = (float)Math.random();
        this.vx = (float)Math.random()*200-100;
        this.vy = (float)Math.random()*200-100;
        this.x = Gdx.graphics.getWidth() * (float)Math.random();
        this.y = Gdx.graphics.getHeight() * (float)Math.random();
        this.w = texture.getWidth();
        this.h = texture.getHeight();
        this.r = w / 2*scale;
        this.rotate = (float)Math.random()*100;
        this.vrotate = 1-(float)Math.random()*2;

    }

    public void render(SpriteBatch batch) {
        batch.draw(textureRegion, x, y,r,r,w*scale,h*scale,scale,scale,rotate);
        //batch.draw(textureRegion, x, y,r,r,w*scale,h*scale,scale,scale,1);
    }

    public void update(float dt) {
        x += vx * dt;
        y += vy * dt;

        if (x + r < 0) {
            x = Gdx.graphics.getWidth() + r;
        }

        if (x - r > Gdx.graphics.getWidth()) {
            x = 0 - r;
        }

        if (y + r < 0) {
            y = Gdx.graphics.getWidth() + r;
        }

        if (y - r > Gdx.graphics.getWidth()) {
            y = 0 - r;
        }

        rotate+=vrotate;

    }
}

