package com.mygdx.game.Constructores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

public class SonidoJuego implements Runnable{
private  String file;
private Sound sonido;
public  SonidoJuego(String file){
this.file=file;
    sonido= Gdx.audio.newSound(Gdx.files.internal(file));
}
    public void play() {

        long id=sonido.play();
        sonido.setPitch(id,1f);
        sonido.setLooping(id,true);
    }
    public void stop() {

        long id=sonido.loop();
        sonido.setPitch(id,1f);
        sonido.setLooping(id,false);
    }
    @Override
    public void run() {

    }
}
