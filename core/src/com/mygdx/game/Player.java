package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by smeleyka on 03.07.17.
 */
public class Player {
    static Texture texture;
    float angle;
    float rotationSpeed;
    float enginePower;
    Vector2 position;
    Vector2 velocity;
    Vector2 accel;
    Vector2 accelx;
    Vector2 accely;


    public Player() {
        this.texture = new Texture("player.png");
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        this.accel = new Vector2(400, 400);
        this.accelx = new Vector2(10, 0);
        this.accely = new Vector2(0, 10);
        this.angle = 0;
        this.rotationSpeed = 2.5f;
        this.enginePower = 250f;

    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y, texture.getWidth() / 2, texture.getHeight() / 2, texture.getWidth(), texture.getHeight(), 1f, 1f, (float) Math.toDegrees(angle), 0, 0, texture.getWidth(), texture.getHeight(), false, false);

    }

    public void update(float dt) {
        //accel.set(0,0);

        if (Gdx.input.isKeyPressed(Input.Keys.W)) {//UP
            accel.set(enginePower * (float) Math.cos(angle + Math.PI / 2), enginePower * (float) Math.sin(angle + Math.PI / 2));
            velocity.add(accel.cpy().scl(dt));
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {//DOWN

        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {//LEFT
            angle -= rotationSpeed * dt;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {//RIGHT
            angle += rotationSpeed * dt;
        }


        if (position.x + texture.getWidth() < 0) position.x = Gdx.graphics.getWidth();
        if (position.y + texture.getHeight() < 0) position.y = Gdx.graphics.getHeight();
        if (position.x > Gdx.graphics.getWidth()) position.x = 0 - texture.getWidth();
        if (position.y > Gdx.graphics.getHeight()) position.y = 0 - texture.getHeight();

        velocity.scl(0.995f);
        position.add(velocity.cpy().scl(dt));

        if (Gdx.input.isKeyPressed(Input.Keys.SPACE)){
            MyGdxGame.bullet.setPosition(position);

        }

    }
}
