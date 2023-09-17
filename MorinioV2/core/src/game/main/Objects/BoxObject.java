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
        ObjectRec = new Rectangle(200,200,100,100);
    }

    @Override
    public void render(){



    }

    @Override
    public void draw(SpriteBatch batch){
        batch.begin();
        batch.draw(img,ObjectRec.x,ObjectRec.y,ObjectRec.width,ObjectRec.height);
        batch.end();
    }
}
