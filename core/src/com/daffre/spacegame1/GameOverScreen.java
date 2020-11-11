package com.daffre.spacegame1;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;

public class GameOverScreen extends BaseScreen {

    public GameOverScreen(Game parent){
        super(parent);
    }

    @Override
    public void show() {
        super.show();
        //Create Table
        Table mainTable = new Table();
        //Set table to fill stage
        mainTable.setFillParent(true);
        //Set alignment of contents in the table.
        mainTable.center();

        //Create label
        Label label = new Label("Game Over!!!", skin);
        label.setScale(1.5f);

        //Create buttons
        TextButton restartButton = new TextButton("Retry", skin);
        TextButton mainMenuButton = new TextButton("Main Menu", skin);

        //Add listeners to buttons
        restartButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.setScreen(new GameScreen(parent));
            }
        });
        mainMenuButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                parent.setScreen(new MainMenuScreen(parent));
            }
        });

        //Add buttons to table
        //TODO: add score display and score itself
        mainTable.add(label);
        mainTable.row();
        mainTable.add(restartButton);
        mainTable.row();
        mainTable.add(mainMenuButton);

        //Add table to stage
        stage.addActor(mainTable);
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


}
