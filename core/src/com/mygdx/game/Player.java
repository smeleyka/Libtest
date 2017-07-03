package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * Created by smeleyka on 03.07.17.
 */
public class Player {
    static Texture texture;
    float x=10;
    float y=10;
    float acceleration=10;
    final float maxSpeed = 500;
    float vx=0;
    float vy=0;


    public Player() {
        this.texture = new Texture("player.png");
    }

    public void render(SpriteBatch batch){
        batch.draw(texture,x,y);
    }

    public void update(float dt){
        if(Gdx.input.isKeyPressed(Input.Keys.W)){//UP
            vy+=acceleration;

        }
        if(Gdx.input.isKeyPressed(Input.Keys.S)){//DOWN
            vy-=acceleration;

        }

        if(Gdx.input.isKeyPressed(Input.Keys.D)){//LEFT
            vx+=acceleration;

        }

        if(Gdx.input.isKeyPressed(Input.Keys.A)){//RIGHT
           vx-=acceleration;


        }
        y+=vy*dt;
        //y-=vy*dt;
        x+=vx*dt;
        //x-=vx*dt;

        if (x>Gdx.graphics.getWidth()) x=0;
        if (x<0) x=Gdx.graphics.getHeight();
        if (y>Gdx.graphics.getHeight()) y=0;
        if (y<0) y=Gdx.graphics.getHeight();
//        if (vy>maxSpeed) vy=maxSpeed;
//        if (vy>-1*maxSpeed) vy=-1*maxSpeed;
//        if (vx>maxSpeed) vx=maxSpeed;
//        if (vx>-1*maxSpeed) vx=-1*maxSpeed;

    }
}
