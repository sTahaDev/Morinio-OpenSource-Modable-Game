package com.Mods.Mods.Deneme;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.components.GameObject;

public class Deneme extends GameObject {

    public SpriteBatch spriteBatch;
    public Texture spriteImg;



    @Override
    public void create(){
        fileName = "Deneme";

        spriteBatch = new SpriteBatch();
        spriteImg = new Texture(getFilePath()+"/tile000.png");

    }

    @Override
    public void render(){
        spriteBatch.begin();
        spriteBatch.draw(spriteImg,ObjectPos.x,ObjectPos.y,200,100);
        spriteBatch.end();
    }

}
