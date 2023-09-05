package com.mygdx.game.components;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

import java.util.LinkedList;

public class Camera{
    private static Vector2 objectsPos = new Vector2();
    private static LinkedList<GameObject> ObjectsList = new LinkedList<GameObject>();

    public Vector2 getNewPos(){
        return objectsPos;
    }

    public void add(GameObject object){
        ObjectsList.add(object);
    }

    public void init(){
        for (int i = 0; i < ObjectsList.size(); i++) {
            ObjectsList.get(i).create();
        }
    }

    public void update(){
        movement();
        for (int i = 0; i < ObjectsList.size(); i++) {
            ObjectsList.get(i).render();
            ObjectsList.get(i).ObjectPos = objectsPos;
        }

    }

    private void movement() {
        // Hareket işlemleri
        float speed = 200 * Gdx.graphics.getDeltaTime();

        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            objectsPos.x -= speed;

        } else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            objectsPos.x += speed;

        } else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            objectsPos.y -= speed;

        } else if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            objectsPos.y += speed;

        }
    }
}
