package com.mygdx.game.components;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EnvanterSlot {
    static SpriteBatch batch;
    static Texture Slot;

    static final int slotCount = 6;
    public static final int startPosX = (1200/2)-(slotCount*90/2);
    public static final int startPosY = 30;

    public static int space = 0;

    public static void create(){
        batch = new SpriteBatch();
        Slot = new Texture("Envanter/slot2.png");

    }

    public static void render(){
        batch.begin();
        for (int i = 0; i < slotCount; i++) {
            batch.draw(Slot,startPosX + space,startPosY);
            space += Slot.getWidth();
        }
        space = 0;
        batch.end();
    }
}
