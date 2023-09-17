package game.main.components;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.MathUtils;

public class Collider {

    public static void addCollider(Rectangle moveableObject,Rectangle staticObject){

        if (moveableObject.overlaps(staticObject)) {
            // İki nesne birbirine temas ediyor, çarpışma tespiti edildi.

            // Şimdi, hangi taraftan çarpışma olduğunu kontrol edin.

            float moveableCenterX = moveableObject.getX() + moveableObject.getWidth() / 2;
            float moveableCenterY = moveableObject.getY() + moveableObject.getHeight() / 2;

            float staticCenterX = staticObject.getX() + staticObject.getWidth() / 2;
            float staticCenterY = staticObject.getY() + staticObject.getHeight() / 2;

            float deltaX = Math.abs(moveableCenterX - staticCenterX);
            float deltaY = Math.abs(moveableCenterY - staticCenterY);

            float halfMoveableWidth = moveableObject.getWidth() / 2;
            float halfMoveableHeight = moveableObject.getHeight() / 2;
            float halfStaticWidth = staticObject.getWidth() / 2;
            float halfStaticHeight = staticObject.getHeight() / 2;

            // X ekseni çarpışma kontrolü
            if (deltaX <= halfMoveableWidth + halfStaticWidth) {
                // X ekseni çarpışma tespit edildi.

                // Şimdi Y ekseni çarpışma kontrolü
                if (deltaY <= halfMoveableHeight + halfStaticHeight) {
                    // Y ekseni çarpışma tespit edildi.

                    // İki nesne birbirine tamamen çarpışıyor olarak kabul edilir.
                    // İstediğiniz işlemleri gerçekleştirin.

                    // Hareketli nesneyi çarpışma noktasından geri çekin
                    float overlapX = halfMoveableWidth + halfStaticWidth - deltaX;
                    float overlapY = halfMoveableHeight + halfStaticHeight - deltaY;

                    if (overlapX < overlapY) {
                        // X ekseni çarpışma öncelikli ise
                        if (moveableCenterX < staticCenterX) {
                            moveableObject.setX(moveableObject.getX() - overlapX);
                        } else {
                            moveableObject.setX(moveableObject.getX() + overlapX);
                        }
                    } else {
                        // Y ekseni çarpışma öncelikli ise
                        if (moveableCenterY < staticCenterY) {
                            moveableObject.setY(moveableObject.getY() - overlapY);
                        } else {
                            moveableObject.setY(moveableObject.getY() + overlapY);
                        }
                    }
                }
            }
        }

    }

}
