package game.main.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Rectangle;

import game.main.components.UIs.HealthBar;

public class GameObject {

    public Rectangle ObjectRec;
    Texture img;
    String fileName = "";
    public String filePath;
    Sprite imgSprite;


    public Rectangle getPlayerRec(){
        return Player.getRec();
    }

    public void createTexture(String fileName){
        img = new Texture(getFilePath()+fileName);
        imgSprite = new Sprite(img);
    }

    public void setTextureMode(int width,int height){

        imgSprite.setSize(width,height);
        ObjectRec.width = imgSprite.getWidth();
        ObjectRec.height = imgSprite.getHeight();
    }

    public void setTextureRotation(float degrees){
        imgSprite.setRotation(degrees);

    }

    public void setPlayerHealth(float health){
        HealthBar.health = health;
    }

    public float getPlayerHealth(){
        return HealthBar.health;
    }

    public int getTextureWidth(){
        return img.getWidth();
    }

    public int getTextureHeight(){
        return img.getHeight();
    }

    public void drawTexture(SpriteBatch screen){

        imgSprite.setX(ObjectRec.x);
        imgSprite.setY(ObjectRec.y);
        imgSprite.draw(screen);
    }

    public String getFilePath(){
        fileName = getClass().getSimpleName();
        filePath = "../core/src/game/Mods/Mods/"+fileName+"/";
        return filePath;
    }

    public void createColliderForPlayer(Rectangle rectngleObject){
        Collider.addCollider(Player.getRec(),rectngleObject);
    }

    public boolean isCollide(Rectangle object){
        boolean isCollide = false;

        isCollide = object.overlaps(Player.getRec());

        return isCollide;
    }

    public void draw(SpriteBatch screen){

    }


    public void create(){


    }

    public void render(){



    }




}
