package com.mygdx.game.vista;


import com.mygdx.game.vista.SnakeGame;

public class Pantalla extends BaseScreen implements Runnable{

    public Pantalla(SnakeGame game)
    {

        super(game);
    }
    @Override
    public void show() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {


    }

    @Override
    public void render(float delta) {

game.gameScreen.start();

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
    public void run() {
    }
}

