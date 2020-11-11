package com.daffre.spacegame1.objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Laser extends GameObject {
    private Texture texture;

    public Laser(float x, float y) {
        super(-400);
        this.x = x;
        this.y = y;

        texture = new Texture("shot.png");
        width = texture.getWidth();
        height = texture.getHeight();
    }

    @Override
    public void render(SpriteBatch batch) {
        move();
        batch.begin();
        batch.draw(texture, x, y);
        batch.end();
    }

    @Override
    public void dispose() {
        texture.dispose();
    }



}