package com.daffre.spacegame1.objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;


public class Asteroid extends Rectangle {
    private final Texture ship;
    private final Texture explosion;
    private final Animation<TextureRegion> explosionAnimation;
    private float stateTime;
    private State state;
    private float speed = 400;
    private Random rand = new Random();

    public Asteroid() {
        explosion = new Texture("explosion3.png");
        explosionAnimation = new Animation<>(0.025f, TextureRegion.split(explosion, explosion.getWidth() / 17, explosion.getHeight())[0]);
        state = State.NORMAL;
        stateTime = 0;
        ship = new Texture("asteroid.png");
        width = (int) Math.round(ship.getWidth() * 1.5);
        height = (int) Math.round(ship.getHeight() * 1.5);
        this.x = Gdx.graphics.getWidth();
        this.y = getRandomY();
    }

    public void render(SpriteBatch batch) {

        x -= speed * Gdx.graphics.getDeltaTime();
        //I'm off the screen
        if ((x + width) < 0) {
            state = State.NORMAL;
            stateTime = 0;
            x = Gdx.graphics.getWidth();
            y = getRandomY();
        }

        batch.begin();
        //handle Explosion

        // Draw asteroid if it hasn't blown up
        if (explosionAnimation.getKeyFrameIndex(stateTime) < 7) {
            batch.draw(new TextureRegion(ship), x, y, width / 2, height / 2, width, height, 1, 1, 90);
        }
        // Draw explosion when needed
        if (state.equals(State.EXPLODING) || state.equals(State.GONE)) {
            stateTime += Gdx.graphics.getDeltaTime();
            batch.draw(explosionAnimation.getKeyFrame(stateTime, false), x, y, width, height);
        }

        batch.end();

        // Set state to gone once it has blown up
        if (explosionAnimation.getKeyFrameIndex(stateTime) == 16) {
            state = State.GONE;

        }
    }

    public void explode() {
        state = State.EXPLODING;
    }

    public int getRandomY() {
        return rand.nextInt(Gdx.graphics.getHeight() + 1 - 0) + 0;
    }

    public void dispose() {
        ship.dispose();
        explosion.dispose();
    }

    public State getState() {
        return state;
    }

    public enum State {
        NORMAL,
        EXPLODING,
        GONE
    }
}
