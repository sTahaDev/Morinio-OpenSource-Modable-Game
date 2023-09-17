package game.main.components;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Map {
    private static Texture map;


    public static void create(){

        map = new Texture("map/map2.png");
    }

    public static void render(SpriteBatch batch){
        batch.begin();
        batch.draw(map,0,0,1200,800);
        batch.end();


    }
}
