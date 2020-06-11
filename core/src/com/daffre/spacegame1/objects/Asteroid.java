package com.daffre.spacegame1.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;


public class Asteroid extends Rectangle {
    private final Texture ship;
    private float speed = 400;
    private Random rand = new Random();

    public Asteroid() {
        ship = new Texture("asteroid.png");
        width = (int) Math.round(ship.getWidth() * 1.5);
        height = (int) Math.round(ship.getHeight() * 1.5);
        this.x = Gdx.graphics.getWidth();
        this.y = getRandomY();
    }

    public void render(SpriteBatch batch){
        x -= speed * Gdx.graphics.getDeltaTime();
        //I'm off the screen
        if ( (x + width) < 0) {
            x = Gdx.graphics.getWidth();
            y = getRandomY();

        }
        batch.begin();

        batch.draw(new TextureRegion(ship), x, y, width / 2, height / 2, width, height, 1, 1, 90);
        batch.end();
    }

    public int getRandomY(){
        return rand.nextInt(Gdx.graphics.getHeight() + 1 - 0) + 0;
    }
    public void dispose(){

    }

}
