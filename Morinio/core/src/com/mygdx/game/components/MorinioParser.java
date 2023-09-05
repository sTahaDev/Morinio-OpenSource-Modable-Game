package com.mygdx.game.components;

import com.badlogic.gdx.math.Vector2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;


public class MorinioParser {

    private static LinkedList<String> ModsList = new LinkedList<>();


    private static String readFile(){
        String filePath = "../core/src/com/Mods/Mods.morinio";
        String text = "";

        try {
            // FileReader ve BufferedReader kullanarak dosyayı okuma işlemi
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Her satırı oku ve ekrana yazdır
                text += line;
            }

            // Dosyaları kapat
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return text;
    }

    public static String[] getFileNames(){
        String text = readFile();
        String[] textArray = text.split(",");

        char[] firstMode,lastMode;

        for (int i = 0; i < textArray.length; i++){
            textArray[i] = textArray[i].replace(" ","");
            textArray[i] = textArray[i].replace("[","");
            textArray[i] = textArray[i].replace("]","");
        }

        return textArray;
    }

}
