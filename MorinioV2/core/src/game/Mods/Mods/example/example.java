package game.Mods.Mods.example;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import game.main.components.GameObject;

public class example extends GameObject {

    @Override
    public void create(){
        createTexture("SteveMinecraft.png");
        ObjectRec = new Rectangle(400,400,getTextureWidth(),getTextureHeight());

    }

    @Override
    public void render(){

        createColliderForPlayer(ObjectRec);

    }

    @Override
    public void draw(SpriteBatch screen){
        drawTexture(screen);
    }
}
