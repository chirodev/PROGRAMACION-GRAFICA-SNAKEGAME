package com.mygdx.game.vista;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.mygdx.game.Constructores.SonidoJuego;
import com.mygdx.game.vista.GameOverScreen;

public class SnakeGame extends Game {
	SpriteBatch batch;
	Texture img;
	public  InicioScreen inicioScreen;
	public  GameOverScreen gameOver;
	public  GameScreen gameScreen;
	public  nuevoIntento nuevoIntento;
	public Pantalla pantalla;
	public  GanadorScreen ganadorScreen;
	public SonidoJuego sonidoJuego;



	@Override
	public void create () {

		nuevoIntento = new nuevoIntento(this);
		sonidoJuego = new SonidoJuego("animacion/sonidojuego.mp3");
		ganadorScreen= new GanadorScreen(this);
		gameScreen = new GameScreen(this);
		pantalla = new Pantalla(this);
		inicioScreen =new InicioScreen(this);
		gameOver = new GameOverScreen(this);
		setScreen(new InicioScreen (this));

	}

}
