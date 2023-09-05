package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
    private static Texture map;
    private static SpriteBatch batch;

    public static void create(){
        batch = new SpriteBatch();
        map = new Texture("map/map2.png");
    }

    public static void render(int x,int y){
        batch.begin();
        batch.draw(map,x,y,1200,900);
        batch.end();
    }
}
