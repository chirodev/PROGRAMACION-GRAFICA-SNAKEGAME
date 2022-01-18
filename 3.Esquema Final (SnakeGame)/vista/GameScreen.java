package com.mygdx.game.vista;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Json;
import com.mygdx.game.Actores.ladrillo;
import com.mygdx.game.Constructores.Posicion;
import com.mygdx.game.Constructores.SonidoJuego;
import com.mygdx.game.Controladores.SnakeController;

import java.util.ArrayList;

import static com.mygdx.game.Controladores.CollisionController.comprobarCollisionManzana;
import static com.mygdx.game.Controladores.SnakeController.*;
import static com.mygdx.game.vista.variablesGlobales.*;

public class GameScreen implements Runnable {
	public ArrayList<ladrillo> ladrillosArray;
	public ArrayList<String>niveles;
private  TextButton play;
	private Skin skin;
	public int numero_niveles=1;

	private Stage stage;
	private SnakeGame game;
	private  SnakeController controller = new SnakeController();

	public SonidoJuego sonidoJuego;
	public  static  SonidoJuego sonidoComer;
	public  static  SonidoJuego sonidoChocoLadrillo;
	public  GameScreen(SnakeGame game){
		this.game=game;
		stage = new  Stage();
		this.ladrillosArray= new ArrayList<ladrillo>();
		this.niveles= new ArrayList<>();
		shapeRenderer=new ShapeRenderer();
		batch=new SpriteBatch();
		snakeHead=new Texture(Gdx.files.internal("snakeHead.png"));
		apple=new Texture(Gdx.files.internal("apple.png"));
		snakeBody=new Texture(Gdx.files.internal("snakeBody.png"));
		niveles.add("nivel1.json");
		niveles.add("nivel2.json");
		bitmapFont = new BitmapFont();
		bitmapFont_Score = new BitmapFont();
		bitmapFont_Vida = new BitmapFont();
		sonidoJuego = new SonidoJuego("animacion/sonidojuego.mp3");
		sonidoComer= new SonidoJuego("animacion/comer.mp3");
		sonidoChocoLadrillo= new SonidoJuego("animacion/choco.mp3");
		System.out.println(contador);
	sonidoJuego.play();
	}
	public void start(){

if(NEW_GAME) {
	switch (state) {
		case PLAYING: {
			cargarnivel();
			cursores();
			actualizarVibora();
			comprobarCollisionManzana();
			comprobarCollisionLadrillo();
			comprobarYPonerManzana();
		}
		break;
		case GAME_OVER: {
			cursores();



		}
		break;

	}
	clearScreen();
	//dibujarCeldas();
	draw();

}else{
	game.setScreen(game.gameOver);
}


	}




	private void clearScreen(){
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

	}

	private void draw(){
		stage.act();
		stage.draw();
		batch.begin();
		batch.draw(snakeHead, snakeX, snakeY);
		for(BodyPart bodyPart:bodyParts){
			bodyPart.draw(batch);
		}
		if (appleAvailable) {
			Score();
			Vida();

			batch.draw(apple, appleX, appleY);
		}

		if (state == STATE.GAME_OVER) {
			layout.setText(bitmapFont, GAME_OVER_TEXT);
			bitmapFont.draw(batch, GAME_OVER_TEXT, 300 ,  200 );

		}


		batch.end();

	}

	private void dibujarCeldas(){
		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		for(int x=0;x<Gdx.graphics.getWidth();x+=GRID_CELL){
			for(int y=0;y<Gdx.graphics.getHeight();y+=GRID_CELL){
				shapeRenderer.rect(x, y, GRID_CELL, GRID_CELL);
			}
		}

		shapeRenderer.end();
	}
	private void Score(){
		SCORE= bodyParts.size;
		layout.setText(bitmapFont_Score, SCORE_TEXT+SCORE);

		bitmapFont_Score.draw(batch, SCORE_TEXT+SCORE, 30 ,  450 );
	}

	private void Vida(){
		layout.setText(bitmapFont_Vida, VIDA_TEXT + VIDA);

		bitmapFont_Vida.draw(batch, VIDA_TEXT + VIDA, 500, 450);

		}

	private void GetNextLevel()
	{
		Json json = new Json();
		FileHandle file = Gdx.files.local(niveles.get(contador));
		String scores = file.readString();
		getPosicion = json.fromJson(Posicion.class, scores);
	//	System.out.println(getPosicion.vector2ArrayList.toString());
	}
	private void cargarLadrillos() {
		int z = 0;
		System.out.println(getPosicion.vector2ArrayList.toString());
		while (z < getPosicion.vector2ArrayList.size()) {
			Vector2 vec = getPosicion.vector2ArrayList.get(z);
			ladrillo auxLadrillo = new ladrillo(new TextureRegion(new Texture("Utilidades/ladrillo.png")), 50, 50, vec.x, vec.y);
			ladrillosArray.add(auxLadrillo);

			stage.addActor(auxLadrillo);


			z++;
		}
	}
	public void cargarnivel() {
		if (NIVEL==1){
			if(bodyParts.size<5){
				GetNextLevel();
				cargarLadrillos();


			}else {
				NIVEL=2;
				state=STATE.PLAYING;
				DIRECCION_VIBORA=PLAY;
				snakeX=0;
				snakeY=0;
				bodyParts.size=0;
				contador= 1;
				game.setScreen(game.nuevoIntento);

				GetNextLevel();
				cargarLadrillos();
			}
		}
		if(NIVEL==2){
			if(bodyParts.size<5){
				GetNextLevel();
				cargarLadrillos();

			}else {
				NIVEL=3;
				state=STATE.PLAYING;
				DIRECCION_VIBORA=PLAY;
				snakeX=0;
				snakeY=0;
				bodyParts.size=0;

				game.setScreen(game.nuevoIntento);
				GetNextLevel();
				cargarLadrillos();
			}
		}
		if (NIVEL==3){
			NIVEL=1;
game.setScreen(game.ganadorScreen);
		}

	}








	@Override
	public void run() {

	}
}
