package com.mygdx.game.Controladores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Actores.ladrillo;
import com.mygdx.game.vista.BodyPart;
import com.mygdx.game.vista.GameScreen;

import static com.mygdx.game.vista.GameScreen.sonidoChocoLadrillo;
import static com.mygdx.game.vista.variablesGlobales.*;
public class SnakeController  {
    public static void cursores() {
        boolean lPressed = Gdx.input.isKeyPressed(Input.Keys.LEFT);
        boolean rPressed = Gdx.input.isKeyPressed(Input.Keys.RIGHT);
        boolean uPressed = Gdx.input.isKeyPressed(Input.Keys.UP);
        boolean dPressed = Gdx.input.isKeyPressed(Input.Keys.DOWN);
        boolean sPressed = Gdx.input.isKeyPressed(Input.Keys.SPACE);

        if (lPressed) updateDirection(LEFT);
        if (rPressed) updateDirection(RIGHT);
        if (uPressed) updateDirection(UP);
        if (dPressed) updateDirection(DOWN);
        if (sPressed) updateDirection(SPACE);


    }

    public static void moveSnake(){
        snakeXBeforeUpdate=snakeX;
        snakeYBeforeUpdate=snakeY;
        switch(DIRECCION_VIBORA){
            case RIGHT: {
                snakeX+=MOVIMIENTO_VIBORA;
                return;
            }
            case LEFT: {
                snakeX-=MOVIMIENTO_VIBORA;
                return;
            }
            case UP: {
                snakeY+=MOVIMIENTO_VIBORA;
                return;
            }
            case DOWN: {
                snakeY-=MOVIMIENTO_VIBORA;
                return;
            }
            case SPACE: {

                return;
            }


        }
    }

    public static void updateDirection(int newSnakeDirection) {
        if (!directionSet && DIRECCION_VIBORA != newSnakeDirection) {
            directionSet = true;
            switch (newSnakeDirection) {
                case LEFT: {
                    updateIfNotOppositeDirection(newSnakeDirection, RIGHT);
                }
                break;
                case RIGHT: {
                    updateIfNotOppositeDirection(newSnakeDirection, LEFT);
                }
                break;
                case UP: {
                    updateIfNotOppositeDirection(newSnakeDirection, DOWN);
                }
                break;
                case DOWN: {
                    updateIfNotOppositeDirection(newSnakeDirection, UP);
                }
                break;
                case  SPACE:{
                    if(state==STATE.GAME_OVER){
                        state=STATE.PLAYING;
                        DIRECCION_VIBORA=PLAY;
                        snakeX=0;
                        snakeY=0;
                        bodyParts.size=0;
                        if(VIDA>1){
                            VIDA=VIDA-1;
                        }else{
                            VIDA=3;
                            NEW_GAME=false;
                        }

                        System.out.println("choco");
                    }
                }
            }
        }
    }
    public static void updateIfNotOppositeDirection(int newSnakeDirection, int oppositeDirection) {
        if (DIRECCION_VIBORA!= oppositeDirection || bodyParts.size==0) DIRECCION_VIBORA = newSnakeDirection;
    }
    public static void actualizarVibora(){
        if(!hasHit){
            timer-=10f;
            if(timer<=0){
                timer=TIEMPO;
                moveSnake();
                verificarFueraDeLimite();
                updateBodyPartsPosition();
                checkSnakeBodyCollision();
                directionSet=false;
            }
        }
    }
    public static void updateBodyPartsPosition(){
        if(bodyParts.size>0){
            BodyPart bodyPart=bodyParts.removeIndex(0);
            bodyPart.actualizarPosicionDelCuerpo(snakeXBeforeUpdate,snakeYBeforeUpdate);
            bodyParts.add(bodyPart);


        }
    }
    public static void chekNivel(){
        if(bodyParts.size>=10){
            BodyPart bodyPart=bodyParts.removeIndex(0);
            bodyPart.actualizarPosicionDelCuerpo(snakeXBeforeUpdate,snakeYBeforeUpdate);
            bodyParts.add(bodyPart);

        }
    }
    public static void verificarFueraDeLimite(){
        if(snakeX>=Gdx.graphics.getWidth()){

            snakeX=0;
        }
        if(snakeX<0){
            snakeX=Gdx.graphics.getWidth()-MOVIMIENTO_VIBORA;
        }
        if(snakeY>=Gdx.graphics.getHeight()){

            snakeY=0;
        }
        if(snakeY<0){
            snakeY=Gdx.graphics.getHeight()-MOVIMIENTO_VIBORA;
        }
    }

    public static void comprobarYPonerManzana(){
        int z = 0;
        if(!appleAvailable){
                    do{
                        appleX= MathUtils.random(Gdx.graphics.getBackBufferHeight()/MOVIMIENTO_VIBORA-1)*MOVIMIENTO_VIBORA;
                        appleY=MathUtils.random(Gdx.graphics.getHeight()/MOVIMIENTO_VIBORA-1)*MOVIMIENTO_VIBORA;
                        appleAvailable=true;
                    } while ((appleX==snakeX && appleY == snakeY) );
                }

        }


    public static void checkSnakeBodyCollision(){
        for(BodyPart bodyPart:bodyParts){
            if(bodyPart.x == snakeX && bodyPart.y==snakeY) ;
        }
    }
    public static void comprobarCollisionLadrillo(){
        int z = 0;
        while (z < getPosicion.vector2ArrayList.size()) {
            Vector2 vec = getPosicion.vector2ArrayList.get(z);

            if ( snakeX== vec.x && snakeY== vec.y){
              //  state=STATE.GAME_OVER;
              // sonidoChocoLadrillo.stop();
            }

            z++;
        }

    }


}