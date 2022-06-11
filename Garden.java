import biuoop.DrawSurface;

import java.awt.Color;


/**
 * The type Garden.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Garden implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(134, 230, 236));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(new Color(78, 23, 23));
        d.fillRectangle(0, 500, 800, 100);
        d.setColor(new Color(56, 132, 13));
        d.fillRectangle(0, 480, 800, 20);
        d.setColor(new Color(66, 191, 18));
        d.fillRectangle(430, 450, 2, 50);
        d.fillRectangle(330, 450, 2, 50);
        d.fillRectangle(630, 450, 2, 50);
        d.setColor(new Color(255, 184, 220));
        d.fillCircle(430, 450, 10);
        d.setColor(new Color(217, 184, 255));
        d.fillCircle(330, 450, 10);
        d.setColor(new Color(255, 212, 184));
        d.fillCircle(630, 450, 10);
        d.setColor(new Color(252, 96, 178));
        for (int i = 0; i < 2; i++) {
            d.fillOval(420 - 5 * i, 458 - 5 * i, 10, 12);
        }
        d.fillOval(413, 445, 10, 12);
        for (int i = 0; i < 2; i++) {
            d.fillOval(415 + 10 * i, 434 - i, 10, 12);
        }
        for (int i = 0; i < 2; i++) {
            d.fillOval(435 + 2 * i, 437 + 10 * i, 10, 12);
        }
        d.fillOval(430, 455, 10, 12);
        d.setColor(new Color(143, 96, 252));
        for (int i = 0; i < 2; i++) {
            d.fillOval(320 - 5 * i, 458 - 5 * i, 10, 12);
        }

        d.fillOval(313, 445, 10, 12);
        for (int i = 0; i < 2; i++) {
            d.fillOval(315 + 10 * i, 434 - i, 10, 12);
        }
        for (int i = 0; i < 2; i++) {
            d.fillOval(335 + 2 * i, 437 + 10 * i, 10, 12);
        }
        d.fillOval(330, 455, 10, 12);
        d.setColor(new Color(252, 194, 79));
        for (int i = 0; i < 2; i++) {
            d.fillOval(620 - 5 * i, 458 - 5 * i, 10, 12);
        }

        d.fillOval(613, 445, 10, 12);
        for (int i = 0; i < 2; i++) {
            d.fillOval(615 + 10 * i, 434 - i, 10, 12);
        }
        for (int i = 0; i < 2; i++) {
            d.fillOval(635 + 2 * i, 437 + 10 * i, 10, 12);
        }
        d.fillOval(630, 455, 10, 12);
        d.setColor(new Color(130, 41, 41));
        d.fillRectangle(200, 380, 50, 120);
        d.setColor(new Color(88, 28, 28));
        d.fillCircle(225, 450, 10);
        d.setColor(new Color(44, 88, 28));
        d.fillCircle(195, 360, 30);
        d.fillCircle(215, 350, 30);
        d.fillCircle(225, 360, 30);
        d.fillCircle(235, 360, 30);
        d.fillCircle(250, 360, 30);
        d.fillCircle(230, 340, 30);
        d.setColor(new Color(248, 224, 23));
        d.fillCircle(500, 200, 100);
        d.setColor(new Color(130, 41, 41));
        d.fillRectangle(700, 380, 50, 120);
        d.setColor(new Color(88, 28, 28));
        d.fillCircle(725, 450, 10);
        d.setColor(new Color(44, 88, 28));
        d.fillCircle(695, 360, 30);
        d.fillCircle(715, 350, 30);
        d.fillCircle(725, 360, 30);
        d.fillCircle(735, 360, 30);
        d.fillCircle(750, 360, 30);
        d.fillCircle(730, 340, 30);

    }


    @Override
    public void timePassed() {

    }
}
