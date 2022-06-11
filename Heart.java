import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Heart.
 * @author Daniel Levy <daniel.levy.mail@gmail.com>
 * ID:208150433
 */
public class Heart implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(128, 0, 0));
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.white);
        d.drawOval(450, 260, 70, 80);
        d.drawOval(550, 260, 70, 80);
        d.drawRectangle(650, 260, 60, 70);
        d.drawLine(650, 270, 650, 400);
    }

    @Override
    public void timePassed() {

    }
}
