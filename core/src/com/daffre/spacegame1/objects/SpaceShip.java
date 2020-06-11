package com.daffre.spacegame1.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;


public class SpaceShip extends Rectangle {
    private final Texture ship;


    public SpaceShip() {
        ship = new Texture("fighter.png");
        width = (int) Math.round(ship.getWidth() * 1.5);
        height = (int) Math.round(ship.getHeight() * 1.5);
        this.y = 0;
        this.x = 50;
    }

    public void render(SpriteBatch batch){

        batch.begin();
        batch.draw(ship, x, y, width, height);
        batch.end();

    }

    public void dispose(){

    }

}
