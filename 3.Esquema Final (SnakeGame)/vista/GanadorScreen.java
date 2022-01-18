package com.mygdx.game.vista;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.mygdx.game.vista.SnakeGame;

public class GanadorScreen extends BaseScreen {
    private TextButton play;
    private Image inicio;
    private Image titulo;
    private Skin skin;
    private Stage stage;

    public GanadorScreen(final SnakeGame game)
    {
        super(game);
        stage= new Stage();
        skin= new Skin(Gdx.files.internal("skin/uiskin.json"));
        inicio= new Image(new Texture("Fondo/Background.png"));
        titulo = new Image(new Texture("Pantallas/ganador.png"));
        play= new TextButton("VOLVER A JUGAR",skin);
        play.setSize(150,35);
        play.setPosition(230,150);
        play.addCaptureListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                game.setScreen(game.inicioScreen);
            }
        });
        titulo.setSize(320,320);
        titulo.setPosition(150,150);
        stage.addActor(inicio);
        stage.addActor(titulo);
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
