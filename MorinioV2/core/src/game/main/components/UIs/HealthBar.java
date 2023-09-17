package game.main.components.UIs;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class HealthBar {
    static private ShapeRenderer backEndImage;
    static private ShapeRenderer frontEndImage;

    static float x,y,w,h;
    static public float health = 3000;
    static float hX,hY,hH;

    static final float maxHealth = 300;



    public static void create(){
        backEndImage = new ShapeRenderer();
        frontEndImage = new ShapeRenderer();

        h = 50;
        x = 13;
        y = 790 - h;
        w = maxHealth + 6;


        hX = x+3;
        hY = y+4;
        hH = h-10;



    }

    public static void render(){

        if (health < 0){
            health = 0;
        }

        if (health/10 > maxHealth){
            health = maxHealth*10;
        }

        backEndImage.begin(ShapeRenderer.ShapeType.Filled);
        backEndImage.setColor(Color.WHITE);
        backEndImage.rect(x,y,w,h);
        backEndImage.end();

        frontEndImage.begin(ShapeRenderer.ShapeType.Filled);
        frontEndImage.setColor(Color.RED);
        frontEndImage.rect(hX,hY,health/10,hH);
        frontEndImage.end();

    }
}
