package game.main.components;

import com.badlogic.gdx.math.Rectangle;

public class Collider {
    public static void addCollider(Rectangle movingBox,Rectangle staticBox){

        //Haraketli Olan MovingBox, Eğer ters yazılırsa movingbox itilebilir bir cisim oluyor
        if (movingBox.overlaps(staticBox)) {



            float overlapX = Math.abs(movingBox.x - staticBox.x);
            float overlapY = Math.abs(movingBox.y - staticBox.y);

            if (overlapX > overlapY) {
                // Yatay çarpışma
                if (movingBox.x > staticBox.x) {
                    movingBox.x = staticBox.x + staticBox.width;
                } else {
                    movingBox.x = staticBox.x - movingBox.width;
                }
            } else {
                // Dikey çarpışma
                if (movingBox.y > staticBox.y) {
                    movingBox.y = staticBox.y + staticBox.height;
                } else {
                    movingBox.y = staticBox.y - movingBox.height;
                }
            }
        }
    }
}
