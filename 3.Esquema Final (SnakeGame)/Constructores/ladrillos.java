package com.mygdx.game.Constructores;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Actores.ladrillo;

import java.util.ArrayList;

public class ladrillos {
    ArrayList<ladrillo>ladrillosArray;
    public ladrillos(Stage stage, ArrayList<ladrillo>arrayList)
    {
        ladrillosArray=arrayList;
        int cont=0;
         while(cont<arrayList.size())
         {
             stage.addActor(arrayList.get(cont));
             cont++;
         }
    }
    public ladrillo getLadrillo(int i)
    {
        return  ladrillosArray.get(i);
    }
}
