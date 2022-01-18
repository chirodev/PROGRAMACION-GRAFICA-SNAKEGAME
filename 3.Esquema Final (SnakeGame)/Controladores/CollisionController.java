package com.mygdx.game.Controladores;

import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Constructores.SonidoJuego;
import com.mygdx.game.vista.BodyPart;
import com.mygdx.game.vista.GameOverScreen;
import com.mygdx.game.vista.SnakeGame;

import static com.mygdx.game.vista.GameScreen.sonidoComer;
import static com.mygdx.game.vista.variablesGlobales.*;
import static com.mygdx.game.vista.variablesGlobales.appleAvailable;

public class CollisionController extends Actor {
    public static SnakeGame game;

    public static void comprobarCollisionManzana(){
        if(appleAvailable && appleX == snakeX && appleY ==snakeY){
            BodyPart bodyPart = new BodyPart(snakeBody);
            bodyPart.actualizarPosicionDelCuerpo(snakeX, snakeY);
            bodyParts.insert(0,bodyPart);

            appleAvailable=false;
                sonidoComer.stop();


        }
    }
}
