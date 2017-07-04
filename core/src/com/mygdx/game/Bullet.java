package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Vector;

/**
 * Created by smeleyka on 04.07.17.
 */
public class Bullet {

    static Texture texture;
    Vector2 position;
    Vector2 velocity;

    public Bullet() {
        texture = new Texture("bullet.png");
        velocity = new Vector2(400, 400);
    }

    public void update(float dt) {
        position.add(velocity.cpy().scl(dt));

    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, position.x, position.y);

    }

    public void setPosition(Vector2 pos) {
        position= pos;

    }

}
