package com.daffre.spacegame1;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.daffre.spacegame1.objects.Asteroid;
import com.daffre.spacegame1.objects.SpaceShip;

public class GameScreen implements Screen {


    private final Asteroid asteroid;
    private SpriteBatch batch;

    private float movementSpeed = 250f;
    private final SpaceShip ship;

    public GameScreen(Game parent) {
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
        if (Gdx.input.isTouched()){
//            float sizeHeight = ship.getHeight() / 2;
            float sizeWidth = ship.getWidth() / 2;
//            ship.setX(Gdx.input.getX()- sizeHeight);
            ship.setY(Gdx.graphics.getHeight() - Gdx.input.getY() - sizeWidth);
        }
        checkCollision();
        ship.render(batch);
        asteroid.render(batch);
    }

    private void checkCollision() {
        if (ship.overlaps( asteroid)){
            Gdx.app.log("Collision", "boooom");
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
