package game.main.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import game.main.components.GameObject;

public class BoxObject extends GameObject {

    Texture img;

    @Override
    public void create(){

        img = new Texture("box.png");
    }

    @Override
    public void render(SpriteBatch batch){
        ObjectRec = new Rectangle(0,0,200,200);
        batch.begin();
        batch.draw(img,ObjectRec.x,ObjectRec.y,ObjectRec.width,ObjectRec.height);
        batch.end();
    }
}
