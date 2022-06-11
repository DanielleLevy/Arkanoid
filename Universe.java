import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Universe.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Universe implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        int w = 1;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 30; j++) {
                d.setColor(Color.white);
                d.fillCircle(50 + 50 * j + w * i, 100 + i * 50, 1);
                d.drawLine(50 + 2 * i, 50 + 2 * i + 2, 30 + 2 * j, 30 + 2 * j + 2);
            }
            w = 20;
            if (i % 2 == 0) {
                w = 1;
            }
        }
        d.setColor(Color.yellow);
        d.fillCircle(0, 200, 100);
        for (int i = 0; i < 700; i += 10) {
            d.drawLine(50, 250, i - 10, 150 - 100);
        }
        d.setColor(Color.gray);
        d.fillCircle(150, 250, 10);
        d.setColor(Color.orange);
        d.fillCircle(200, 250, 20);
        d.setColor(Color.blue);
        d.fillCircle(270, 250, 30);
        d.setColor(Color.red);
        d.fillCircle(350, 250, 25);
        d.setColor(Color.orange);
        d.fillCircle(450, 250, 50);
        d.setColor(Color.yellow);
        d.fillCircle(550, 250, 35);
        d.setColor(Color.cyan);
        d.fillCircle(630, 250, 25);
        d.setColor(Color.blue);
        d.fillCircle(700, 250, 20);
        d.setColor(Color.lightGray);
        d.fillCircle(750, 250, 8);
    }

    @Override
    public void timePassed() {

    }
}
