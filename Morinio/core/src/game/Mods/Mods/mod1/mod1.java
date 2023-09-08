package game.Mods.Mods.mod1;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import game.main.components.GameObject;

public class mod1 extends GameObject {
    Texture img;

    @Override
    public void create(){
        fileName = "mod1";

        img = new Texture(getFilePath()+"SteveMinecraft.png");
    }

    @Override
    public void render(SpriteBatch batch){
        ObjectRec = new Rectangle(400,400,img.getWidth(),img.getWidth());
        batch.begin();
        batch.draw(img,ObjectRec.x,ObjectRec.y,ObjectRec.width,ObjectRec.height);
        batch.end();
    }
}
