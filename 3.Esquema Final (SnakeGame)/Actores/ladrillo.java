package com.mygdx.game.Actores;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;


public class ladrillo extends Actor {
    private TextureRegion Pieza;
    public Rectangle rectangle;

    public ladrillo(TextureRegion texture, int sizeX, int sizeY, float positionX, float positionY) {
        this.Pieza=texture;
        setSize(sizeX,sizeY);
        setPosition(positionX,positionY);
        rectangle= new Rectangle(getX(),getY(),getWidth(),getHeight());
    }
    @Override
    public void act(float delta) {
       rectangle.height=getHeight();
       rectangle.width=getWidth();
       rectangle.x=getX();
       rectangle.y=getY();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.draw(Pieza,getX(),getY(),32,32);
    }

    @Override
    public void clear() {
        setSize(0,0);
        rectangle.setSize(0,0);
        remove();
    }
}
