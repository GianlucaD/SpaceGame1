package com.daffre.spacegame1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.daffre.spacegame1.objects.Asteroid;
import com.daffre.spacegame1.objects.Laser;
import com.daffre.spacegame1.objects.SpaceShip;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class GameScreen extends BaseScreen {

    private final Asteroid asteroid;
    private SpriteBatch batch;

    private float movementSpeed = 250f;
    private final SpaceShip ship;
    private List<Laser> lasers = new ArrayList<>();

    public GameScreen(Game parent) {
        super(parent);
        batch = new SpriteBatch();
        asteroid = new Asteroid();
        ship = new SpaceShip();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (Gdx.input.isTouched()) {
            float sizeWidth = ship.getWidth() / 2;
            ship.setY(Gdx.graphics.getHeight() - Gdx.input.getY() - sizeWidth);
            lasers.add(ship.shoot());
        }
        checkCollision();
        for (Iterator<Laser> iterator = lasers.iterator(); iterator.hasNext(); ) {
            Laser laser = iterator.next();
            if (laser.getX() > Gdx.graphics.getWidth()) {
                laser.dispose();
                iterator.remove();
            } else {
                laser.render(batch);
            }
        }
        ship.render(batch);
        if (asteroid.getState() != Asteroid.State.GONE) {
            asteroid.render(batch);
        }
        if (asteroid.getState() == Asteroid.State.GONE){
            asteroid.dispose();
        }
    }

    private void checkCollision() {
        if (ship.overlaps(asteroid) && asteroid.getState() == Asteroid.State.NORMAL) {
            if (asteroid.getState() == Asteroid.State.NORMAL) {
                asteroid.explode();
            }
            if (asteroid.getState() == Asteroid.State.GONE) {
                parent.setScreen(new GameOverScreen(parent));
            }
        }
        for (Iterator<Laser> iterator = lasers.iterator(); iterator.hasNext(); ) {
            Laser laser = iterator.next();
            if (laser.overlaps(asteroid) && asteroid.getState() == Asteroid.State.NORMAL){
                asteroid.explode();
                laser.dispose();
            }
        }
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        ship.dispose();
        batch.dispose();

    }
}
