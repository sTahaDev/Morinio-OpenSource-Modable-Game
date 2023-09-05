package com.Mods.Mods.mymod;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.components.GameObject;

public class mymod extends GameObject {

    public SpriteBatch spriteBatch;
    public Texture spriteImg;



    @Override
    public void create(){
        fileName = "mymod";

        spriteBatch = new SpriteBatch();
        spriteImg = new Texture(getFilePath()+"/steve.png");

    }

    @Override
    public void render(){
        spriteBatch.begin();
        spriteBatch.draw(spriteImg,ObjectPos.x+200,ObjectPos.y+200,200,100);
        spriteBatch.end();
    }

}
