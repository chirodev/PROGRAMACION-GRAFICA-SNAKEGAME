package com.mygdx.game.vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


import static com.mygdx.game.vista.variablesGlobales.NEW_GAME;
import static com.mygdx.game.vista.variablesGlobales.batch;
public class GameOverScreen extends BaseScreen {
    private TextButton play;
    private Image inicio;
    private Image fin;
    private Skin skin;
    private Stage stage;
    public GameOverScreen(final SnakeGame game)
    {
        super(game);
        stage= new Stage();
        skin= new Skin(Gdx.files.internal("skin/uiskin.json"));
        inicio= new Image(new Texture("Fondo/Background.png"));
        play= new TextButton("VOLVER",skin);
        play.setSize(150,35);
        play.setPosition(230,150);
        fin = new Image(new Texture("Pantallas/perder.png"));
        fin.setSize(320,320);
        fin.setPosition(150,150);
        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.inicioScreen);
                NEW_GAME=true;
            }
        });
        stage.addActor(inicio);
        stage.addActor(fin);
        stage.addActor(play);

    }
    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();


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
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();

    }
}