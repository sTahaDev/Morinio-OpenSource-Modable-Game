package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Animation.PlayMode;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import org.w3c.dom.Text;

public class Player {
    private SpriteBatch batch;
    private Texture[] playerImages = new Texture[6];
    private Texture[] playerRunImagesRight = new Texture[6];
    private Texture[] playerRunImagesUp = new Texture[6];
    private Texture[] playerRunImagesLeft = new Texture[6];
    private Animation<Texture> playerAnimation;
    private Animation<Texture> playerRunAnimationRight;
    private Animation<Texture> playerRunAnimationUp;
    private Animation<Texture> playerRunAnimationLeft;
    private float totalTime;
    private Texture currentFrame;
    private String lookAt = "down";
    private Vector2 playerPos;



    public void create() {
        batch = new SpriteBatch();
        int imageCountRunRight = 6;
        int imageCountRunUp = 12;
        int imageCountLeft = 6;




        for (int i = 0; i < playerImages.length; i++) {
            playerImages[i] = new Texture("player/tile" + String.format("%03d", i) + ".png");
        }

        for (int i = 0; i < playerRunImagesLeft.length; i++) {
            if(imageCountLeft > 9){
                playerRunImagesLeft[i] = new Texture("player/left/tile" + "0"+imageCountLeft+".png");
            }else{
                playerRunImagesLeft[i] = new Texture("player/left/tile" + "00"+imageCountLeft+".png");
            }
            imageCountLeft += 1;
        }



        for (int i = 0; i < playerRunImagesRight.length; i++) {
            if (imageCountRunRight > 9) {
                playerRunImagesRight[i] = new Texture("player/tile" + "0" + imageCountRunRight + ".png");
            } else {
                playerRunImagesRight[i] = new Texture("player/tile" + String.format("%03d", imageCountRunRight) + ".png");
            }
            imageCountRunRight += 1;
        }

        for (int i = 0; i < playerRunImagesUp.length; i++) {
            playerRunImagesUp[i] = new Texture("player/tile" + "0" + imageCountRunRight + ".png");
            imageCountRunRight += 1;
        }

        playerAnimation = new Animation<Texture>(0.13f, new Array<Texture>(playerImages), PlayMode.LOOP);
        playerRunAnimationRight = new Animation<Texture>(0.13f, new Array<Texture>(playerRunImagesRight), PlayMode.LOOP);
        playerRunAnimationUp = new Animation<Texture>(0.13f, new Array<Texture>(playerRunImagesUp), PlayMode.LOOP);
        playerRunAnimationLeft = new Animation<Texture>(0.13f, new Array<Texture>(playerRunImagesLeft), PlayMode.LOOP);

        playerPos = new Vector2(1200/2-playerImages[0].getWidth()-50,800/2-playerImages[0].getHeight());

    }

    public void render() {

        movement();
        batch.begin();
        totalTime += Gdx.graphics.getDeltaTime();

        float scaleX = 3f; // X ekseni ölçek faktörü (diğer yönlere uygulanan ölçek)
        float scaleY = 3f; // Y ekseni ölçek faktörü (diğer yönlere uygulanan ölçek)

        if (lookAt.equals("down")) {
            currentFrame = playerAnimation.getKeyFrame(totalTime);
        } else if (lookAt.equals("right")) {
            currentFrame = playerRunAnimationRight.getKeyFrame(totalTime);
        } else if (lookAt.equals("up")) {
            currentFrame = playerRunAnimationUp.getKeyFrame(totalTime);
        } else if (lookAt.equals("left")) {
            currentFrame = playerRunAnimationLeft.getKeyFrame(totalTime);
        }
        batch.draw(currentFrame, playerPos.x, playerPos.y, currentFrame.getWidth() * scaleX,currentFrame.getHeight() * scaleY);



        batch.end();
    }


    public void dispose() {
        batch.dispose();
        for (Texture texture : playerImages) {
            texture.dispose();
        }
        for (Texture texture : playerRunImagesRight) {
            texture.dispose();
        }
        for (Texture texture : playerRunImagesUp) {
            texture.dispose();
        }
    }

    private void movement() {
        // Hareket işlemleri
        float speed = 200 * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            lookAt = "right";

        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            lookAt = "left";

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            lookAt = "up";

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            lookAt = "down";

        }
    }
}
