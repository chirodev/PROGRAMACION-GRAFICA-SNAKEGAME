package com.mygdx.game.vista;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.Constructores.Posicion;


public  class variablesGlobales {
    public static SpriteBatch batch;
    public static Texture snakeHead;

    public  static final float TIEMPO= 100.2F;
    public static float timer = TIEMPO;
    public  static final int MOVIMIENTO_VIBORA=32;
    public static int snakeX=0, snakeY=0;
    public  static final int RIGHT=0;
    public  static final int LEFT=1;
    public  static final int UP=2;
    public  static final int DOWN=3;
    public  static final int PLAY=4;
    public  static final int SPACE=5;
public static final boolean GAME_OVER=false;
    public static int DIRECCION_VIBORA=PLAY;

    public static Texture apple;
    public static boolean appleAvailable=false;
    public static int appleX, appleY;

    public static Texture snakeBody;
    public static Array<BodyPart> bodyParts= new Array<BodyPart>();
    public static int snakeXBeforeUpdate=0, snakeYBeforeUpdate=0;

    public static ShapeRenderer shapeRenderer;
    public static final int GRID_CELL=32;
    public  static    int SCORE =0;
    public  static    int NIVEL =1;
    public  static    int VIDA =3;
    public static int contador=0;
    public static boolean directionSet=false;
    public static boolean hasHit=false;
    public  static boolean NEW_GAME=true;
    public static Posicion getPosicion= new Posicion();
    public  enum STATE {
        PLAYING, GAME_OVER, NEXT_LEVEL
    }
    public static STATE state=STATE.PLAYING;

    public static BitmapFont bitmapFont;
    public static BitmapFont bitmapFont_Score;
    public static BitmapFont bitmapFont_Vida;
    public static GlyphLayout layout = new GlyphLayout();


    public static Viewport viewport;

    public  static final String GAME_OVER_TEXT="Game Over!";
    public  static final String SCORE_TEXT="SCORE:";
    public  static final String VIDA_TEXT="VIDA:";
    public  static boolean choco= false;
}
