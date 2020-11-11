package com.daffre.spacegame1.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class GameObject extends Rectangle {
    protected int speed;

    public GameObject(int speed) {
        this.speed = speed;
    }

    public abstract void render(SpriteBatch batch);
    public abstract void dispose();

    protected void move() {
        x -= speed * Gdx.graphics.getDeltaTime();
    }
}
