package game.main.components;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ModManager {

    public void create(){
        if (MorinioParser.getFileNames().length != 0){
            for (int i = 0; i < MorinioParser.getFileNames().length; i++) {
                try {
                    String sinifAdi = MorinioParser.getFileNames()[i];
                    Class<?> clazz = Class.forName("game.Mods.Mods." + sinifAdi + "." + sinifAdi); // Sınıfı adından yükle
                    Object instance = clazz.newInstance(); // Yeni bir örnek oluştur
                    if (instance instanceof GameObject) {
                        GameObject gameObject = (GameObject) instance;
                        Mods.addMod(gameObject);

                    }


                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }



}
