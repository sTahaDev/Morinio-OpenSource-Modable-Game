package game.main.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

public class GameObject {

    public Rectangle ObjectRec;

    public String fileName = "";
    public String filePath;

    SpriteBatch batch;

    public String getFilePath(){
        filePath = "../core/src/game/Mods/Mods/"+fileName+"/";
        return filePath;
    }


    public void create(){


    }

    public void render(SpriteBatch batch){


    }




}
