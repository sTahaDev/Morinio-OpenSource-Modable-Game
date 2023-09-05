package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.mygdx.game.components.*;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class Game extends ApplicationAdapter {
    Player player = new Player();
    Camera camera = new Camera();

    OrthographicCamera gdxCamera;

    SpriteBatch batch;


    @Override
    public void create() {
        batch = new SpriteBatch();
        player.create();
        Map.create();

        gdxCamera = new OrthographicCamera();
        gdxCamera.setToOrtho(false,1200,800); // Görüntüleme ekranının boyutuna göre ayarlayın
        gdxCamera.position.set(502,352,0); // Oyuncu pozisyonuna ayarlayın
        gdxCamera.update();

        Viewport viewport = new FitViewport(1200, 800, gdxCamera);
        for (int i = 0; i < MorinioParser.getFileNames().length; i++) {
            try {
                String sinifAdi = MorinioParser.getFileNames()[i];
                Class<?> clazz = Class.forName("com.Mods.Mods." + sinifAdi + "." + sinifAdi); // Sınıfı adından yükle
                Object instance = clazz.newInstance(); // Yeni bir örnek oluştur
                if (instance instanceof GameObject) {
                    GameObject gameObject = (GameObject) instance;
                    camera.add(gameObject);

                }


            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        camera.init();


    }

    @Override
    public void render() {

        ScreenUtils.clear(1, 0, 0, 1);
        Map.render((int) camera.getNewPos().x, (int) camera.getNewPos().y);
        batch.setProjectionMatrix(gdxCamera.combined);
        player.render();
        camera.update();

        gdxCamera.position.set(502, 352, 0); // Oyuncu pozisyonunu güncelle
        gdxCamera.update();


    }

    @Override
    public void dispose() {
        player.dispose();
    }
}
