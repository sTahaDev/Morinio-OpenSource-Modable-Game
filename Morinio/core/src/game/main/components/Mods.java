package game.main.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.LinkedList;

public class Mods {

    public static LinkedList<GameObject> ModsList = new LinkedList<>();

    public static void addMod(GameObject object){
        ModsList.add(object);
    }

    public static void create(){
        for(GameObject i: ModsList){
            i.create();
        }
    }

    public static void render(SpriteBatch batch){
        for(GameObject i: ModsList){
            i.render(batch);
        }
    }
}
