package com.mygdx.game.Constructores;

import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;

public class Posicion {
    public ArrayList<Vector2>vector2ArrayList = new ArrayList<Vector2>();
    public  void add(int x, int y)
    {
        vector2ArrayList.add(new Vector2(x,y));
    }
}
