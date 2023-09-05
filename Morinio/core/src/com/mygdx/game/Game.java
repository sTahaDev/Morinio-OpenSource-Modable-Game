package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import com.mygdx.game.Objects.*;
import com.mygdx.game.components.*;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;


public class Game extends ApplicationAdapter {
	Player player = new Player();
	Camera camera = new Camera();



	
	@Override
	public void create () {
		player.create();
		camera.init();

		EnvanterSlot.create();
		Map.create();

		//Camera Adding


		try {
			String sinifAdi  = "Deneme";
			Class<?> clazz = Class.forName("com.mygdx.game.Objects."+sinifAdi); // Sınıfı adından yükle
			Object instance = clazz.newInstance(); // Yeni bir örnek oluştur
			if (instance instanceof GameObject) {
				GameObject gameObject = (GameObject) instance;
				camera.add(gameObject);
				// GameObject özelliklerini veya yöntemlerini kullanabilirsiniz
			}


		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}



	}

	@Override
	public void render () {

		ScreenUtils.clear(1, 0, 0, 1);
		Map.render((int)camera.getNewPos().x,(int)camera.getNewPos().y);
		player.render();

		camera.update();

		EnvanterSlot.render();

	}
	
	@Override
	public void dispose () {
		player.dispose();
	}
}
