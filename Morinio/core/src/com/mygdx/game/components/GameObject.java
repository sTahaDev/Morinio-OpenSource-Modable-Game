package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class GameObject {
    public Vector2 ObjectPos = new Vector2(0,0);
    public Vector2 PlayerPos = new Vector2(502,352);

    public String fileName = "";
    public String filePath;

    public String getFilePath(){
        filePath = "../core/src/com/Mods/Mods/"+fileName;
        return filePath;
    }

    public void create(){


    }

    public void render(){


    }




}
